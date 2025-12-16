package com.pstorli.composemvvmsample.model

import com.pstorli.composemvvmsample.R

/**
 * This class is used for logic that is short lived,
 * as we are on the ui thread here. The reason is that
 * I like to keep the viewModel as solely a data repository,
 * and as little logic, functions, as possible.
 */

class VMHelper (var viewModel: ViewModel)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////

    // Used to run coroutines in the background.
    var ch   = CoHelper (viewModel)

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Functions
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Toggle running
     */
    fun toggleRunning() {
        // toggle runninmg state
        viewModel.running = !viewModel.running

        // Button text.
        var word: String

        // Are we running?
        if (viewModel.running) {
            // Start color blaster class

            // Make sure that back thread running.
            // This task throws out random colors at random times.
            // In this app it is simulatinmg outside data trickling in.
            ch.startBackgroundTask()

            // Pressing button now starts back color task.
            word = viewModel.app.getText(R.string.stop).toString()
        }
        else {
            // Pressing button now stops back color task.
            word = viewModel.app.getText(R.string.start).toString()
        }

        // set the button text.
        viewModel.btnText  = word

        // get word color in back.
        ch.getWordColorInBackground (word)
    }
}