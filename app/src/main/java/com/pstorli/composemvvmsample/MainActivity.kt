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
import com.pstorli.composemvvmsample.ui.theme.CurrentTheme

/**
This class is the applications main activity.

This is the only place we instantiate the ViewModel.kt class.
It is passed to composeables on their constructor.

The function, onCreate, in MainActivity.kt

override fun onCreate(savedInstanceState: Bundle?) {}

is called when program starts up and is on the ui thread, so no long running operations here, just call setContent to set the composeable to view,
In this case, StartScreen.kt
 */

class MainActivity : ComponentActivity() {
    val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        "MainActivity.onCreate Started!".logInfo()

        enableEdgeToEdge()
        setContent {
            CurrentTheme {
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