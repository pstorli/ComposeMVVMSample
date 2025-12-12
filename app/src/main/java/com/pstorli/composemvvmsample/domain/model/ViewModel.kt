package com.pstorli.composemvvmsample.domain.model

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.util.Consts.randomLightColor
import com.pstorli.composemvvmsample.util.Prefs
import androidx.compose.ui.graphics.Color

class ViewModel (val app: Application) : AndroidViewModel (app)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////
    var running         by mutableStateOf<Boolean>(false)

    @Suppress("unused")
    var prefs           = Prefs(app) // Preferences, initialize first

    // The button background color.
    var buttonColor     by mutableStateOf<Color>(randomLightColor ())

    // The button text.
    var buttonText       by mutableStateOf<String>(app.resources.getText(R.string.start).toString())

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Functions
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Toggle running
     */
    fun toggleRunning ()
    {
        // toggle runninmg state
        running = !running

        // set button background color
        buttonColor = randomLightColor ()

        // Are we running?
        if (running) {
            buttonText = app.getText(R.string.stop).toString()
        }
        else {
            buttonText = app.getText(R.string.start).toString()
        }
    }
}
