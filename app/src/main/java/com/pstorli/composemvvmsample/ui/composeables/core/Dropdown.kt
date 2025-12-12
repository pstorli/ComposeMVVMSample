package com.pstorli.composemvvmsample.ui.composeables.core

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pstorli.composemvvmsample.R
import com.pstorli.pokerpic.ui.composeables.core.Pic

val SETTINGS_DOWN_ARROW_SIZE_DP         = 18.dp

/**
 * Show a drop down list.
 *
 * @param items         - The items to display in the drop down list.
 * @param prompt        - Prompt contains same row ahead of drop down.
 * @param index         - Currently selected index.
 * @param onValueChange - Callback to invoke when drop down selection changes.
 * @param getTextColor  - The item's text can be used to color the indicated item.
 * @param backColor     - The background color.
 * @param tintColor     - This color colors the dropdown icon.
 */
@Composable
fun Dropdown (
    items: List<Any>,
    prompt: String,
    index: Int=ZERO,
    onValueChange: (String) -> Unit,
    getTextColor: (String) -> Color,
    backColor: Color=colorScheme.background,
    tintColor: Color=colorScheme.secondary)
{
    Row (modifier               = Modifier.height(IntrinsicSize.Min).fillMaxWidth(),
        horizontalArrangement   = Arrangement.Start,
        verticalAlignment       = Alignment.Top) {

        val indexInRange = if (index>=0 && index<items.size) index else 0 // Make sure that the index is in range.
        var expanded by remember { mutableStateOf(false) }
        var selectedIndex by remember { mutableStateOf(indexInRange) }
        Box (modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)) {

            Row (modifier               = Modifier.height(IntrinsicSize.Min).fillMaxWidth(),
                horizontalArrangement   = Arrangement.Start,
                verticalAlignment       = Alignment.CenterVertically) {

                // Show prompt
                Text (text=prompt, fontSize = 26.sp, color = getTextColor (prompt))

                // A bit of space between the two.
                HSpacer (12.dp)

                // Show the selected item and drop down arrow.
                // Side by side rows the same height
                // make these two rows, the children, the same height.
                Row (horizontalArrangement   = Arrangement.SpaceBetween,
                    verticalAlignment        = Alignment.Top,
                    modifier                 = Modifier
                        .height(IntrinsicSize.Min)
                        .fillMaxWidth()
                        .border (
                            width = 2.dp,
                            color = colorScheme.outline,
                            shape = RectangleShape
                        )
                        .padding(6.dp, 6.dp, 6.dp, 6.dp)
                        .clickable
                        {
                            expanded = true
                        }
                    )
                    {

                    // The selected item.
                    Text (
                        text     = items[selectedIndex].toString(),
                        color    = getTextColor (items[selectedIndex].toString()),
                        modifier = Modifier.background(backColor).clickable (
                            onClick =
                            {
                                expanded = true
                            }
                        )
                    )

                    // The drop down arrow. Adjust image for dark mode.
                    Pic (
                        resId           = R.drawable.down_arrow,
                        sizeDp          = SETTINGS_DOWN_ARROW_SIZE_DP,
                        showBorder      = false,
                        backColor       = backColor,
                        tintColor       = tintColor,
                        modifier        = Modifier.background(backColor).clickable (
                            onClick =
                            {
                                expanded = true
                            }
                        )
                    )
                }
            }

            DropdownMenu (
                expanded            = expanded,
                onDismissRequest    = { expanded = false },
                modifier            = Modifier.fillMaxWidth().background(backColor)
            ) {
                items.forEachIndexed { indexInRange, selected ->
                    DropdownMenuItem(
                        text = { Text(text = selected.toString()) },
                        onClick = {
                            // 1. Handle the click action (e.g., update the selected item)
                            var selectedItem = selected

                            // 2. Crucially, dismiss the menu after an item is clicked
                            expanded = false

                            // Value changed
                            onValueChange(items[selectedIndex].toString())
                        })
                }
            }
        }
    }
}