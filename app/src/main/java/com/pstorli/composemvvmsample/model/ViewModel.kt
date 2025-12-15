package com.pstorli.composemvvmsample.model

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.util.Prefs
import androidx.compose.ui.graphics.Color

class ViewModel (val app: Application) : AndroidViewModel (app)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // View Model Helper classes.
    // I like to only keep essential, data in this class.
    // I like to keep logic out, rather have helper classes perform logic.
    // /////////////////////////////////////////////////////////////////////////////////////////////

    // Used to run coroutines in the back.
    var vh    = VMHelper (this)

    // Preferences, initialize first
    // Questionable if these should be accessed through the repo.
    @Suppress("unused")
    var prefs = Prefs(app)

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////

    var running by mutableStateOf<Boolean>(false)

    // The app back color.
    var backColor by mutableStateOf<Color>(Color.White)

    // The button back color.
    var btnBackColor by mutableStateOf<Color>(Color.Cyan)

    // The button text.
    var btnText by mutableStateOf<String>(app.resources.getText(R.string.start).toString())

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Init things
    // /////////////////////////////////////////////////////////////////////////////////////////////
    init {
        // NOOP, FUBAR
    }
}


