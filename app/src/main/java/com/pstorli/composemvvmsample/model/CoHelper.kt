package com.pstorli.composemvvmsample.model

import androidx.lifecycle.viewModelScope
import com.pstorli.composemvvmsample.color
import com.pstorli.composemvvmsample.logError
import com.pstorli.composemvvmsample.logInfo
import com.pstorli.composemvvmsample.logVerbose
import com.pstorli.composemvvmsample.logWarning
import com.pstorli.composemvvmsample.repo.Repo
import com.pstorli.composemvvmsample.util.Consts
import com.pstorli.composemvvmsample.util.Consts.MAX_DELAY
import com.pstorli.composemvvmsample.util.Consts.MIN_DELAY
import com.pstorli.composemvvmsample.util.Consts.randomColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

class CoHelper (var viewModel: ViewModel)
{
    // Our continual back task.
    private var bj: Job?    = null

    // Used to request long running data
    // Repository stuff, do long running things in the back.
    // Thereason that it is private, i that people requesting
    // access to the repo, should go through this class,
    // so that the request is done on a backgroung thread,
    // because long running operatio9ns should
    // NOT BE DONE ON THE UI THREAD
    private var repo         = Repo (viewModel)

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // These routines cause coroutines to be run in back
    // so ui thread is not used for 'long running' operations.
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Use this as an exampole of asking the repo for something
     * in the back, so we don't hang ui thread.
     *
     * Get a color on the back thread.
     *
     * To simulate how to have a long running
     * routine not hang up the ui threead.
     */
    @Suppress("unused")
    fun getWordColorInBack (word: String) {
        "getWordColorInBack() started ... ".logVerbose()

        viewModel.viewModelScope.launch {
            // Get the game, the whole enchilada.
            val fetchColorDeferred = viewModel.viewModelScope.async (Dispatchers.Main)
            {
                repo.getColorOfWord (word)
            }

            // Wait for it. new button color
            val color = fetchColorDeferred.await()

            // Go back contains ui thread.
            // This causes us to rejoin the ui thread,
            withContext(Dispatchers.Main) {

                // Update the button color in the view model.
                viewModel.btnBackColor = color

                "getWordColorInBack() Button Color = ${viewModel.btnBackColor.color()} ".logInfo()
                "getWordColorInBack() finished.".logVerbose()

            }
        }
    }

    /**
     * Use this as an exampole of asking the repo for something
     * in the back, so we don't hang ui thread.
     *
     * Get a color on the back thread.
     *
     * To simulate how to have a long running
     * routine not hang up the uio threead.
     */
    @Suppress("unused")
    fun startBackTask () {
        // Stop it!
        if (!viewModel.running) {
            bj = null
            return
        }

        // Already active?
        if (bj?.isActive?:false) {
            return
        }

        // ***************************************************************** //
        "Switching execution to the back thread ...".logInfo()
        // ***************************************************************** //

        "BackTask started.".logVerbose()
        "BackTask Setting button color ...".logVerbose()

        // Launch the coroutine and keep track of task.
        bj = viewModel.viewModelScope.launch {
            // The while (running) is the "flag" for continuous operation.
            // If the Job is cancelled, 'running' becomes false, and the loop exits.
            do {
                try {
                    // Are we done?
                    if (viewModel.running) {
                        // Perform the back work here.
                        // NOTE: Any suspending function (like delay) checks for cancellation automatically.
                        "BackTask running...".logVerbose()

                        // Wait 1 - 5 seconds
                        val time = (Consts.rndNum(MIN_DELAY, MAX_DELAY)).toLong()
                        "BackTask Delaying: $time".logVerbose()

                        delay(time)

                        // Now change the back color.
                        viewModel.backColor = randomColor()

                        // Write color change to log.
                        "BackTask Back color set to: ${viewModel.backColor.color()} ".logInfo()
                    }
                    else {
                        "BackTask Cancelled".logWarning()
                    }
                }
                catch (e: CancellationException) {
                    // Re-throw CancellationException to propagate cancellation
                    "BackTask CancellationException in back task: ${e.message}".logError(e)
                    viewModel.running = false
                    throw e
                }
                catch (e: Exception) {
                    viewModel.running = false
                    // Handle other exceptions (e.g., network error)
                    "BackTask Error in back task: ${e.message}".logError(e)
                    "BackTask Delaying 5000L millis".logVerbose()
                    delay(5000L) // Wait before retrying
                }
            } while (viewModel.running)

            // null out task, will re-create if startBackTask is called again.
            bj = null

            // We're done.
            "BackTask finished.".logVerbose()
        }
    }
}