package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.pstorli.composemvvmsample.logError

@Composable
fun TextLinks (
    fullText: String,
    links: Map<String, String>,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    linkTextColor: Color = Color.Blue,
    linkTextFontWeight: FontWeight = FontWeight.Normal,
    linkTextDecoration: TextDecoration = TextDecoration.Underline,
    fontSize: TextUnit = TextUnit.Unspecified,
    clicked:(result:String)->Unit={})
{
    val annotatedString = buildAnnotatedString {
        append(fullText)

        for((key, value) in links) {
            val startIndex = fullText.indexOf(key)
            val endIndex = startIndex + key.length

            // Error / insanity check.
            if (startIndex<0 || endIndex<0) {
                "TextLinks Key: $key $startIndex $endIndex".logError()
            }

            addStyle(
                style = SpanStyle(
                    color = linkTextColor,
                    fontSize = fontSize,
                    fontWeight = linkTextFontWeight,
                    textDecoration = linkTextDecoration
                ),
                start = startIndex,
                end = endIndex
            )
            addStringAnnotation(
                tag = "CLICK_ID",
                annotation = value,
                start = startIndex,
                end = endIndex
            )
        }
        addStyle(
            style = SpanStyle(
                fontSize = fontSize
            ),
            start = 0,
            end = fullText.length
        )
    }

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        style = textStyle,
        onClick = {
            annotatedString
                .getStringAnnotations("CLICK_ID", it, it)
                .firstOrNull()?.let { soundAnnotation ->
                    clicked (soundAnnotation.item)
                }
        }
    )
}