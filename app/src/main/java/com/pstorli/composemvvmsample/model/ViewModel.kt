package com.pstorli.composemvvmsample.model

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.util.Prefs
import androidx.compose.ui.graphics.Color
import com.pstorli.composemvvmsample.util.Consts

class ViewModel (val app: Application) : AndroidViewModel (app)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // View Model Helper classes.
    // I like to only keep essential, data in this class.
    // I like to keep logic out, rather have helper classes perform logic.
    // /////////////////////////////////////////////////////////////////////////////////////////////

    // Used to run coroutines in the background.
    var vh    = VMHelper (this)

    @Suppress("unused")
    var prefs = Prefs(app) // Preferences, initialize first

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////

    var running by mutableStateOf<Boolean>(false)

    // The app background color.
    var backColor by mutableStateOf<Color>(Color.White)

    // The button background color.
    var buttonBackgroundColor by mutableStateOf<Color>(Color.Blue)

    // The button text.
    var buttonText by mutableStateOf<String>(app.resources.getText(R.string.start).toString())

    // the button text color.
    var buttonTextColor by mutableStateOf<Color>(Consts.TEXT_START_COLOR)

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Init things
    // /////////////////////////////////////////////////////////////////////////////////////////////
    init {
        // NOOP, FUBAR
    }
}


