package com.pstorli.composemvvmsample.util

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * The main reason to use constants, is
 * that we can keep everyone in agreement -
 * even it is wrong, we are all wrong and if
 * right we are all-right.
 *
 * In either case both still work.
 *
 * ALSO - The values below are for lookup only,
 * do not use to display to the user - use localization instead
 * I am using them for logging.
 * See Strings.xml
 *
 */
object Consts {
    // *********************************************************************************************
    // Vars
    // *********************************************************************************************

    val TAG_NAME                                = "ComposeMVVMSample"

    val FONT_SIZE   : TextUnit                  = 28.sp

    val TEXT_COLOR                              = Color.Black

    // *********************************************************************************************
    // Log helper functions
    // *********************************************************************************************

    /**
     * Log an error message.
     */
    @Suppress("unused")
    fun logError(ex: Exception) {
        logError(TAG_NAME, ex.toString())
    }

    /**
     * Log an error message.
     */
    fun logError(msg: String) {
        logError(TAG_NAME, msg)
    }

    /**
     * Log an error message.
     */
    fun logError(msg: String, t: Throwable? = null) {
        Log.e (TAG_NAME, msg, t)
    }

    /**
     * Log an error message.
     */
    fun logError(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    /**
     * Log an error message.
     */
    fun logWarning(msg: String) {
        Log.w(TAG_NAME, msg)
    }

    /**
     * Log an error message.
     */
    fun logWarning(tag: String, msg: String) {
        Log.w(tag, msg)
    }

    /**
     * Log an info message.
     */
    fun logInfo(msg: String) {
        System.out.println (TAG_NAME + " " + msg)
    }

    /**
     * Log an info message.
     */
    fun logInfo(tag: String, msg: String) {
        Log.i(tag, msg)
    }

    /**
     * Log a debug message.
     */
    fun debug (msg: String) {
        System.out.println(TAG_NAME + " " + msg)
    }

    // *********************************************************************************************
    // More helper functions
    // *********************************************************************************************


    /**
     * Return random num between 1 and 100
     */
    fun rndNum (): Int {
        return rndNum (1, 100)
    }

    /**
     * Return random num between start and end
     */
    fun rndNum (start:Int, end:Int): Int {
        return (start..end).random()
    }
}