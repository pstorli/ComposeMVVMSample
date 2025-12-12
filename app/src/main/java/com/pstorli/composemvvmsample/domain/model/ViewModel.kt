package com.pstorli.composemvvmsample.domain.model

import android.app.Application
import android.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.util.Prefs

class ViewModel (val app: Application) : AndroidViewModel (app)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////
    var running by mutableStateOf(false)
        private set

    @Suppress("unused")
    var prefs           = Prefs(app) // Preferences, initialize first

    // The button background color.
    var buttonColor by mutableStateOf(Color.GREEN)
        private set

    // The button text.
    var buttonText by mutableStateOf(app.resources.getText(R.string.start).toString())
        private set

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Functions
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Toggle running
     */
    fun toggleRunning ()
    {
        running = !running

        // Are we running?
        if (running) {
            buttonText = app.getText(R.string.stop).toString()
            buttonColor = Color.RED
        }
        else {
            buttonText = app.getText(R.string.start).toString()
            buttonColor = Color.GREEN
        }
    }
}
