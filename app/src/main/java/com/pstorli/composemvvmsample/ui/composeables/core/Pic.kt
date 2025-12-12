package com.pstorli.pokerpic.ui.composeables.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pstorli.composemvvmsample.ui.composeables.core.ZERO
import com.pstorli.composemvvmsample.ui.composeables.core.conditional

/**
 * Create a pic composeable.
 */
@Composable
fun Pic (modifier: Modifier = Modifier, resId: Int=ZERO, tintColor: Color=Color.Black, padding: Dp = 4.dp, showBorder: Boolean=true, borderColor: Color=MaterialTheme.colorScheme.outline, backColor: Color=MaterialTheme.colorScheme.background, contentDescription: String="", sizeDp: Dp?=null) {
    Pic(modifier, resId, tintColor, padding, showBorder, borderColor, backColor, contentDescription, sizeDp, null)
}

/**
 * Create a pic composeable.
 */
@Composable
fun Pic (modifier: Modifier = Modifier, resId: Int=ZERO, tintColor: Color=Color.Black, padding: Dp = 4.dp, showBorder: Boolean=true, borderColor: Color=MaterialTheme.colorScheme.outline, backColor: Color=MaterialTheme.colorScheme.background, contentDescription: String="", sizeDp: Dp?=null, onClick: (() -> Unit?)?) {
    Image (
        painterResource     (resId),
        contentDescription  = contentDescription,
        contentScale        = ContentScale.Fit,
        colorFilter         = ColorFilter.tint(tintColor),
        modifier            = modifier
            .padding(padding)
            .background(backColor)
            .conditional(showBorder) {
                border(BorderStroke(2.dp, borderColor), RectangleShape)
            }
            .conditional(sizeDp != null) {
                size(sizeDp!!)
            }
            .conditional(onClick != null) {
                clickable {
                    onClick?.let { it() }
                }
            }
    )
}
