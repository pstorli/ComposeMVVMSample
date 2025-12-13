package com.pstorli.composemvvmsample.model

import androidx.lifecycle.viewModelScope
import com.pstorli.composemvvmsample.color
import com.pstorli.composemvvmsample.logError
import com.pstorli.composemvvmsample.logInfo
import com.pstorli.composemvvmsample.logVerbose
import com.pstorli.composemvvmsample.logWarning
import com.pstorli.composemvvmsample.util.Consts
import com.pstorli.composemvvmsample.util.Consts.MAX_DELAY
import com.pstorli.composemvvmsample.util.Consts.MIN_DELAY
import com.pstorli.composemvvmsample.util.Consts.randomLightColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

class CoHelper (var viewModel: ViewModel)
{
    // Our continual background task.
    private var bj: Job?    = null
    private var done        = false

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // These routines cause coroutines to be run in background
    // so ui thread is not used for 'long running' operations.
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Use this as an exampole of asking the repo for something
     * in the background, so we don't hang ui thread.
     *
     * Get a color on the background thread.
     *
     * To simulate how to have a long running
     * routine not hang up the uio threead.
     */
    @Suppress("unused")
    fun getButtonColorInBackground() {
        "getButtonColorInBackground() started ... ".logVerbose()

        viewModel.viewModelScope.launch {
            // Get the game, the whole enchilada.
            val fetchColorDeferred = viewModel.viewModelScope.async (Dispatchers.Main)
            {
                viewModel.repo.getColorOfWord (viewModel.buttonText)
            }

            // Wait for it. new button color
            val color = fetchColorDeferred.await()

            // Go back contains ui thread.
            withContext(Dispatchers.Main) {

                // Update the button color.
                viewModel.buttonColor = color

                "getButtonColorInBackground() Button Color = ${viewModel.buttonColor.color()} ".logInfo()
                "getButtonColorInBackground() finished.".logVerbose()

            }
        }
    }

    /**
     * Use this as an exampole of asking the repo for something
     * in the background, so we don't hang ui thread.
     *
     * Get a color on the background thread.
     *
     * To simulate how to have a long running
     * routine not hang up the uio threead.
     */
    @Suppress("unused")
    fun startBackgroundTask () {
        // Only launch if it's not already active
        if (bj?.isActive?:false) return

        done = false

        "BackgroundTask started.".logVerbose()
        "BackgroundTask Setting button color ...".logVerbose()

        // Launch the coroutine and keep track of task.
        bj = viewModel.viewModelScope.launch {
            // The while (running) is the "flag" for continuous operation.
            // If the Job is cancelled, 'running' becomes false, and the loop exits.
            do {
                try {
                    // Are we done?
                    done = viewModel.running && bj?.isActive ?: false
                    if (!done) {
                        // Perform the background work here.
                        // NOTE: Any suspending function (like delay) checks for cancellation automatically.
                        "BackgroundTask running...".logVerbose()

                        // Wait 1 - 5 seconds
                        val time = (Consts.rndNum(MIN_DELAY, MAX_DELAY)).toLong()
                        "BackgroundTask Delaying: $time".logVerbose()

                        delay(time)

                        // Now change the background color.
                        viewModel.backColor = randomLightColor()

                        // Write color change to log.
                        "BackgroundTask Background color set to: ${viewModel.backColor.color()} ".logInfo()
                    }
                    else {
                        "BackgroundTask Cancelled".logWarning()
                    }
                }
                catch (e: CancellationException) {
                    done = true
                    // Re-throw CancellationException to propagate cancellation
                    "BackgroundTask CancellationException in background task: ${e.message}".logError(e)
                    throw e
                }
                catch (e: Exception) {
                    done = true
                    // Handle other exceptions (e.g., network error)
                    "BackgroundTask Error in background task: ${e.message}".logError(e)
                    "BackgroundTask Delaying 5000L millis".logVerbose()
                    delay(5000L) // Wait before retrying
                }
            } while (!done)

            // null out task, will re-create if startBackgroundTask is called again.
            bj = null

            // We're done.
            "BackgroundTask finished.".logVerbose()
        }
    }
}