package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun VSpacer () {
    VSpacer (12.dp)
}

@Composable
fun VSpacer (dp: Dp) {
    Spacer (modifier = Modifier.height(dp))
}