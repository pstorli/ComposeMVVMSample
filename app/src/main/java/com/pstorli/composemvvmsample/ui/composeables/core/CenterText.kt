package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun CenterText (text: String, fontSize: TextUnit = FONT_SIZE_TEXT_SP, color: Color = MaterialTheme.colorScheme.primary) {
    Row (modifier               = Modifier
        .height(IntrinsicSize.Min)
        .fillMaxWidth()
        .padding (start = 8.dp),
        horizontalArrangement   = Arrangement.Center,
        verticalAlignment       = Alignment.Top) {

        // Show app name.
        Text (text = text, color = color, fontSize = fontSize)
    }
}

@Composable
fun CenterText (text: AnnotatedString, fontSize: TextUnit = FONT_SIZE_TEXT_SP, color: Color = MaterialTheme.colorScheme.primary) {
    Row (modifier               = Modifier
        .height(IntrinsicSize.Min)
        .fillMaxWidth()
        .padding (start = 8.dp),
        horizontalArrangement   = Arrangement.Center,
        verticalAlignment       = Alignment.Top) {

        // Show app name.
        Text (text = text, color = color, fontSize = fontSize)
    }
}