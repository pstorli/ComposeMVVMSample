package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val SNACKBAR_FONT_SIZE_SP           = 20.sp
val ROUNDED_CORNER_SHAPE_PCT_VAL    = 20

@Composable
fun SnackBar (
    snackbarData: SnackbarData,
    backgroundColor: Color  = MaterialTheme.colorScheme.background,
    borderColor:     Color  = MaterialTheme.colorScheme.outline,
    contentColor:    Color  = MaterialTheme.colorScheme.surface) {

    Card(
        shape = RoundedCornerShape(ROUNDED_CORNER_SHAPE_PCT_VAL),
        border = BorderStroke(2.dp, borderColor),
        // backgroundColor = backgroundColor,
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize()
    ) {
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center)
        {
            Text (
                text     = snackbarData.toString(),
                color    = contentColor,
                fontSize = SNACKBAR_FONT_SIZE_SP
            )
        }
    }
}