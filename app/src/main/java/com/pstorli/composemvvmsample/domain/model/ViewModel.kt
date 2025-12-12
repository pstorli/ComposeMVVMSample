package com.pstorli.composemvvmsample.domain.model

import android.app.Application
import android.graphics.Color
import androidx.lifecycle.AndroidViewModel
import com.pstorli.composemvvmsample.util.Prefs

class ViewModel (val app: Application) : AndroidViewModel (app)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Vars
    // /////////////////////////////////////////////////////////////////////////////////////////////
    var prefs           = Prefs(app) // Preferences, initialize first

    // The button color.
    var buttonColor     = Color.GREEN
}