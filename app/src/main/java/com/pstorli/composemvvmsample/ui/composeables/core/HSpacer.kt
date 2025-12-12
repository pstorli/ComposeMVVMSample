package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HSpacer () {
    HSpacer (8.dp)
}

@Composable
fun HSpacer (dp: Dp) {
    Spacer (modifier = Modifier.width(dp))
}