package com.pstorli.composemvvmsample.model

import com.pstorli.composemvvmsample.R

class VMHelper (var viewModel: ViewModel)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////

    // Used to run coroutines in the background.
    protected var ch   = CoHelper (viewModel)

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Functions
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Toggle running
     */
    fun toggleRunning() {
        // toggle runninmg state
        viewModel.running = !viewModel.running

        // Make sure that background thread running.
        // This task throws out random colors at random times.
        // In this app it is simulatinmg outside data trickling in.
        ch.startBackgroundTask()

        // Are we running?
        if (!viewModel.running) {
            // Pressing button now stops background color task.
            val stop = viewModel.app.getText(R.string.stop).toString()
            viewModel.buttonText  = stop
            viewModel.buttonColor = viewModel.repo.getColorOfWord(stop)
        } else {
            // Pressing button now starts background color task.
            val start = viewModel.app.getText(R.string.start).toString()
            viewModel.buttonText  = start
            viewModel.buttonColor = viewModel.repo.getColorOfWord(start)
        }

        // set button background color in a background thread.
        ch.getButtonColorInBackground()
    }
}