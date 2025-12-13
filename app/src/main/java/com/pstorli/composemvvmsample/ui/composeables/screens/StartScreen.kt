package com.pstorli.composemvvmsample.ui.composeables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pstorli.composemvvmsample.model.ViewModel
import com.pstorli.composemvvmsample.util.Consts.FONT_SIZE
import com.pstorli.composemvvmsample.util.Consts.TEXT_COLOR

@Composable
fun StartScreen (viewModel: ViewModel, modifier: Modifier = Modifier)
{
    // Make button appear center screen.
    Box (
        // Note, we set the background window color here.
        modifier             = Modifier.fillMaxSize().background (viewModel.backColor),
        contentAlignment     = Alignment.Center)
    {
        Button(
            // Toggle running state when clicked
            onClick = {
                viewModel.vh.toggleRunning()
            },

            // Handle button text and button backgriound color
            colors = ButtonDefaults.buttonColors (
                contentColor    = TEXT_COLOR,                            // text
                containerColor  = Color (viewModel.buttonColor.value)    // background

            ),
            contentPadding  = ButtonDefaults.ButtonWithIconContentPadding)
        {
            Text (
                // From file strings.xml
                text     = viewModel.buttonText,
                color    = TEXT_COLOR,
                fontSize = FONT_SIZE,
                modifier = modifier
            )
        }
    }
}
