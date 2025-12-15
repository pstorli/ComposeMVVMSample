package com.pstorli.composemvvmsample.ui.composeables.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pstorli.composemvvmsample.model.ViewModel
import com.pstorli.composemvvmsample.ui.composeables.core.OutlinedButton

@Composable
fun StartScreen (viewModel: ViewModel, modifier: Modifier = Modifier)
{
    // Make button appear center screen.
    Box (
        // Note, we set the back window color here.
        modifier             = Modifier.fillMaxSize().background (viewModel.backColor),
        contentAlignment     = Alignment.Center)
    {
        // A custom button I made, in ui.composeables.core
        // that adds an colored, outline border
        OutlinedButton (
            name        = viewModel.btnText,
            backColor   = Color (viewModel.btnBackColor.value),
            borderColor = Color.Red,

            // Toggle running state when clicked
            onClick     = {
                viewModel.vh.toggleRunning()
            })
    }
}
