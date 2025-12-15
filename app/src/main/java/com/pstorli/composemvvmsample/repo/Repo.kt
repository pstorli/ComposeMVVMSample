package com.pstorli.composemvvmsample.repo

import androidx.compose.ui.graphics.Color
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.darkChoice
import com.pstorli.composemvvmsample.model.ViewModel
import com.pstorli.composemvvmsample.getString
import com.pstorli.composemvvmsample.inDarkMode

/**
 * This class routes requests for data to the correct repository.
 * This class is also a singleton.
 */
class Repo (var viewModel: ViewModel)
{
    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Prefs Helper Methods
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Fetch a color.+
     */
    fun getColorOfWord (word: String): Color {
        val ctx   = viewModel.app.getBaseContext()
        var color: Color
        when (word) {
            viewModel.getString (R.string.start)   -> color = ctx.darkChoice (Color.Green,   Color.Magenta)
            viewModel.getString (R.string.stop)    -> color = ctx.darkChoice (Color.Red,     Color.Yellow)
            else                                        -> color = ctx.darkChoice (Color.Magenta, Color.Green)
        }
        return color
    }


}