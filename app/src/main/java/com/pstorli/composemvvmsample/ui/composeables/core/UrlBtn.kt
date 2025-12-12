package com.pstorli.composemvvmsample.ui.composeables.core

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val URL_PADDING_DP  = 8.dp
val SHAPE           = RoundedCornerShape(8.dp)

@Composable
fun UrlBtn (uri: String, text: String, context: Context, linkColor: Color = colorScheme.secondary) {
    val btnBackColor = MaterialTheme.colorScheme.background
    Row(
        modifier = Modifier
            .border(2.dp, colorScheme.outline, shape = SHAPE)
            .background(
                color = btnBackColor,
                shape = SHAPE
            ),
    ) {
        Url (uri, text, context, URL_PADDING_DP, linkColor)
    }
}