/*
 * Add our extension functions here.
 */

package com.pstorli.composemvvmsample

import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration
import android.media.MediaPlayer
import androidx.compose.ui.graphics.Color
import com.pstorli.composemvvmsample.model.ViewModel
import com.pstorli.composemvvmsample.util.Consts

// *********************************************************************************************
// Extension Log helper functions
// *********************************************************************************************

/**
 * Log an error message.
 */
@Suppress("unused")
fun Exception.logError ()
{
    Consts.logError (this.toString())
}

/**
 * Log an error message.
 */
@Suppress("unused")
fun String.logError (t: Throwable? = null)
{
    Consts.logError (this, t)
}

/**
 * Log an error message.
 */
@Suppress("unused")
fun String.logError ()
{
    Consts.logError (this)
}

/**
 * Log an error message.
 */
@Suppress("unused")
fun String.logError (tag: String)
{
    Consts.logError (tag, this)
}

/**
 * Log an error message.
 */
@Suppress("unused")
fun String.logWarning ()
{
    Consts.logWarning ( this)
}

/**
 * Log an error message.
 */
@Suppress("unused")
fun String.logWarning (tag: String)
{
    Consts.logWarning (tag, this)
}

/**
 * Log an info message.
 */
fun String.logInfo ()
{
    Consts.logInfo (this)
}

/**
 * Log an info message.
 */
fun String.logVerbose ()
{
    Consts.logVerbose (this)
}

/**
 * Log an info message.
 */
@Suppress("unused")
fun String.logInfo (tag: String)
{
    Consts.logInfo (tag, this)
}

/**
 * Log an info message.
 */
fun String.debug ()
{
    Consts.debug (this)
}
/**
 * Log an info message.
 */
fun String.empty (): Boolean
{
    return 0 == this.length
}

// *********************************************************************************************
// More helper functions
// *********************************************************************************************

/**
 * Set night/dark mode.
 */
fun Context.setDarkMode (state: Boolean) {
    val uiManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
    if (state) {
        uiManager.nightMode = UiModeManager.MODE_NIGHT_YES
    } else {
        uiManager.nightMode = UiModeManager.MODE_NIGHT_NO
    }
}

/**
 * Toggle night/dark mode?
 */
fun Context.toggleDarkMode () {
    setDarkMode (inDarkMode ())
}

/**
 * Are we in night/dark mode?
 */
fun Context.inDarkMode (): Boolean {
    val darkModeFlag = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return darkModeFlag == Configuration.UI_MODE_NIGHT_YES
}

/**
 * Return a random color.
 * If in dark mode, color will be light,
 * If normal mode, color will tend darker.
 */
fun Context.createRandomColor (): Color {
    var start   = 0
    var end     = 128
    if (inDarkMode ()) {
       start = 128
       end   = 256
    }

    val red     = (start..end).random ()
    val green   = (start..end).random ()
    val blue    = (start..end).random ()

    return Color (red=red, green=green, blue=blue)
}

/**
 * Retrieve a resource string using a key that is a string, instead of a resource id.
 */
fun Context.getResStringByName (name: String): String {
    try {
        return getString(resources.getIdentifier(name, "string", packageName))
    }
    catch (ex: Exception) {
        ex.logError()
        return name
    }
}

/**
* Retrieve a resource string using a key that is a string, instead of a resource id.
*/
fun ViewModel.getString (id: Int): String {
    return app.getString (id)
}

/**
 * Retrieve a resource string using a key that is a string, instead of a resource id.
 */
fun Context.getString (id: Int): String {
    try {
        return resources.getString (id)
    }
    catch (ex: Exception) {
        ex.logError()
        return ""
    }
}

/**
 * Convert a string to a file name.
 */
fun String.removePng (): String {
    return subSequence(0, indexOf(".png")).toString()
}

/**
 * Play a sound.
 */
fun Context.playSound (soundRawId: Int) {
    try {
        // Create it.
        var mp: MediaPlayer? = MediaPlayer.create (this, soundRawId)
        mp?.let {
            if (mp.isPlaying == true) {
                // Stop, drop and roll.
                mp.stop()
                mp.release()

                // Then re-create it.
                mp = MediaPlayer.create(this, soundRawId)
            }

            // Now start it.
            mp?.start()
        }
    }
    catch (ex: Exception) {
        ex.toString().logError()
    }
}

/**
 * Return color as rgb string.
 */
fun Color.color (): String {
    return (red.toString() +","+ green.toString() +","+ blue.toString())
}





