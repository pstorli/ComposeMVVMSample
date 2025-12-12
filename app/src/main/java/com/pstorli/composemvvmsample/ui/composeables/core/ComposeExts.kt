package com.pstorli.composemvvmsample.ui.composeables.core

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

val FONT_SIZE_TINY_SP                   = 16.sp
val FONT_SIZE_SM_SP                     = 18.sp // val xxTEXT_FONT_SIZE_SP               = 18.sp
val FONT_SIZE_TEXT_SP                   = 22.sp
val FONT_SIZE_MED_SP                    = 24.sp
val FONT_SIZE_LG_SP                     = 26.sp
val FONT_SIZE_LGER_SP                   = 28.sp // val xTITLE_FONT_SIZE_SP              = 28.sp
val FONT_SIZE_TITLE_SP                  = 36.sp
val NO_TEXT                             = ""
val TTS_PAUSE                           = "... "
val TTS_SPEECH_RATE                     = 0.66f
val ZERO                                = 0

/**
 * Add a modifier conditionally.
 */
fun Modifier.conditional (condition : Boolean, modifier : Modifier.() -> Modifier) : Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}

/**
 * Create a path in assets dir.
 */
fun createAssetsPath (assetsFolder: String, file: String): String {
    return ASSETS_DIR +'/'+assetsFolder+'/'+file
}

/**
 * Open this url.
 */
fun Context.openLink (link: String) {
    var url = link
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
        url = "http://" + url
    }
    val browserIntent = Intent (Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(browserIntent)
}