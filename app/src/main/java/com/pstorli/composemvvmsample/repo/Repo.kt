package com.pstorli.composemvvmsample.repo

import androidx.compose.ui.graphics.Color
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.darkChoice
import com.pstorli.composemvvmsample.model.ViewModel
import com.pstorli.composemvvmsample.getString

/** This class handles talking to remote data sources
to get data in the background, such as images from urls,
websites, vpn, or even local database , which is considered slow.

This class is currently designed to be called from class CoHelper.kt
so that it is never called directly from the ui thread.
If request is needed, add methods to CoHelper.kt to get to the
Repo.kt method you want to talk to.

The function getColorOfWord, normally does not need to be here,
it is not long running. But it have it here as an example
of how a longer running
routine should be handled.

    fun getColorOfWord (word: String): Color

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