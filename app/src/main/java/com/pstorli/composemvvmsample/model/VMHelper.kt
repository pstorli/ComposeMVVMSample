package com.pstorli.composemvvmsample.model

import com.pstorli.composemvvmsample.R

class VMHelper (var viewModel: ViewModel)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////

    // Used to run coroutines in the back.
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

        // Are we running?
        var word: String

        // Are we running?
        if (viewModel.running) {
            // Start color blaster class

            // Make sure that back thread running.
            // This task throws out random colors at random times.
            // In this app it is simulatinmg outside data trickling in.
            ch.startBackTask()

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
        ch.getWordColorInBack (word)
    }
}