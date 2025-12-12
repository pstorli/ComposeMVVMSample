package com.pstorli.composemvvmsample.ui.composeables.core

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Url (uri: String, text: String, context: Context, padding: Dp = 0.dp, linkColor: Color = colorScheme.secondary) {
    val btnBackColor = MaterialTheme.colorScheme.background
    var modifier = Modifier.padding (2.dp)
    if (padding>0.dp) {
        modifier = Modifier.background(btnBackColor).padding (URL_PADDING_DP)
    }
    ClickableText(
        modifier    = modifier,
        text        = AnnotatedString(text),
        style       = TextStyle(
            textDecoration  = TextDecoration.Underline,
            fontWeight      = FontWeight.Bold,
            fontSize        = FONT_SIZE_TINY_SP,
            color           = linkColor
        )
    )
    {
        context.openLink (uri)
    }
}