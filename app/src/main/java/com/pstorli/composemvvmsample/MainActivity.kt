package com.pstorli.composemvvmsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pstorli.composemvvmsample.model.ViewModel
import com.pstorli.composemvvmsample.ui.composeables.screens.StartScreen
import com.pstorli.composemvvmsample.ui.theme.ComposeMVVMSampleTheme

class MainActivity : ComponentActivity() {
    val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        "MainActivity.onCreate Started!".logVerbose()

        enableEdgeToEdge()
        setContent {
            ComposeMVVMSampleTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StartScreen (
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}