package com.pstorli.composemvvmsample.domain.model

import android.app.Application
import android.graphics.Color
import androidx.lifecycle.AndroidViewModel
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.util.Prefs

class ViewModel (val app: Application) : AndroidViewModel (app)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Whether or not the update trhread is running or not.
    private var running         = false

    private var prefs           = Prefs(app) // Preferences, initialize first

    // The button color.
    private var buttonColor     = Color.GREEN

    // The button text.
    private var buttonText      = app.resources.getText(R.string.stop).toString()

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Getters and Setters
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Are we running?
     */
    fun isRunning (): Boolean
    {
        return running
    }

    /**
     * Toggle running
     */
    fun toggleRunning ()
    {
        setRunning (!isRunning ())
    }

    /**
     * Set the running state.
     */
    fun setRunning (isRunning: Boolean = false) {
        this.running = isRunning

        // Are we running?
        if (isRunning) {
            setButtonText (app.getText(R.string.stop).toString())
        }
        else {
            setButtonText (app.getText(R.string.start).toString())
        }
    }

    /**
     * Prefs
     */
    fun getPrefs(): Prefs {
        return prefs
    }

    fun setPrefs(prefs: Prefs) {
        this.prefs = prefs
    }

    /**
     * Button Color
     */
    fun getButtonColor(): Int {
        return buttonColor
    }

    fun setButtonColor(buttonColor: Int) {
        this.buttonColor = buttonColor
    }

    /**
     * Button Text
     */
    fun getButtonText (): String {
        return buttonText
    }

    fun setButtonText (buttonText: String) {
        this.buttonText = buttonText
    }


}