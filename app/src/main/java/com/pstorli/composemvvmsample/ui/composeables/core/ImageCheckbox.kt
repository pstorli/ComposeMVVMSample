import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pstorli.composemvvmsample.R
import com.pstorli.composemvvmsample.util.Consts.TEXT_COLOR
import com.pstorli.pokerpic.ui.composeables.core.Pic

val CHECK_BOX_SIZE_DP = 24.dp

@Composable
fun ImageCheckbox (checked: Boolean, tintColor: Color =TEXT_COLOR, onCheckedChange: (Boolean) -> Unit) {
    Pic (
        resId       = if (checked) R.drawable.check_mark else R.drawable.blank,
        tintColor   = tintColor,
        showBorder  = true,
        padding     = 8.dp,
        sizeDp      = CHECK_BOX_SIZE_DP,
        onClick     =
        {
            onCheckedChange (!checked)
        }
    )
}