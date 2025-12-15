package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pstorli.pokerpic.ui.composeables.core.Pic

val DEFAULT_ELEVATION_VAL_DP                = 10.dp
val DISABLED_ELEVATION_VAL_DP               = 0.dp
val PRESSED_ELEVATION_VAL_DP                = 15.dp

val BORDER_SZ_DP                            = 2.dp
val BTN_MIN_WIDTH_DP                        = 48.dp
val BTN_PADDING_DP                          = 4.dp
val ROUNDED_CORNER_PCT_VAL                  = 20
val PADDING                                  = 4.dp

@Composable
fun OutlinedButton (
    name: String = NO_TEXT,
    resId: Int=ZERO,
    imageSizeDp: Dp?=null,
    textColor: Color = if(isSystemInDarkTheme()) Color.White else Color.Black,
    tintColor: Color=Color.Black,
    backColor: Color=if(isSystemInDarkTheme()) Color.Black else Color.White,
    borderColor: Color=MaterialTheme.colorScheme.outline,
    fontSize: TextUnit = 32.sp,
    padding: Dp = 4.dp,
    onClick: (Int) -> Unit) {

    OutlinedButton(
        onClick = {
            // Do that click thing.
            onClick.invoke(ZERO)
        },
        border = BorderStroke(BORDER_SZ_DP, borderColor),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = backColor),
        /*elevation =  ButtonDefaults.buttonElevation(
            defaultElevation  = DEFAULT_ELEVATION_VAL_DP,
            pressedElevation  = PRESSED_ELEVATION_VAL_DP,
            disabledElevation = DISABLED_ELEVATION_VAL_DP
        ),*/
        shape           = RoundedCornerShape(ROUNDED_CORNER_PCT_VAL),
        modifier        = Modifier
            .padding(BTN_PADDING_DP)
            .requiredWidthIn(min = BTN_MIN_WIDTH_DP)
            .widthIn(min = BTN_MIN_WIDTH_DP),
        contentPadding  = PaddingValues(BTN_PADDING_DP)
    )
    {
        if (name.isEmpty() && resId>ZERO) {
            // We are already in a border, so don't show border contains pic.
            Pic (resId=resId, sizeDp=imageSizeDp, showBorder=false, backColor=backColor, tintColor=tintColor)
        }
        else {
            Text (
                text     = name,
                color    = textColor,
                modifier = Modifier.padding (padding),
                fontSize = fontSize)
        }
    }
}