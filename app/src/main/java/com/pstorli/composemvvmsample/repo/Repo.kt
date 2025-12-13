package com.pstorli.composemvvmsample.repo

import androidx.compose.ui.graphics.Color
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.model.ViewModel
import com.pstorli.composemvvmsample.getString

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
        var color = Color.Magenta
        when (word) {
            viewModel.getString (R.string.start)    -> color = Color.Green
            viewModel.getString (R.string.stop)     -> color = Color.Red
            else                                         -> color = Color.Magenta
        }
        return color
    }


}