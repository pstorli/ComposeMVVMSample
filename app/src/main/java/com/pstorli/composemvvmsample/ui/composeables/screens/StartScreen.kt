package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.domain.model.ViewModel

@Composable
fun StartScreen (viewModel: ViewModel, modifier: Modifier = Modifier)
{
    // Make button appear cenetr scrteen.
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
        Button(
            onClick = {
                viewModel.toggleRunning()
            },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding)
        {
            Text (
                // From file strings.xml
                text     = viewModel.getButtonText(),
                modifier = modifier
            )
        }
    }
}
