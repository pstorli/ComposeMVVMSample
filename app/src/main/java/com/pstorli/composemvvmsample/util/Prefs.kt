package com.pstorli.composemvvmsample.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class Prefs (application: Application) {
    // *********************************************************************************************
    // EmoDS Vars
    // *********************************************************************************************
    val PREFERENCE_FILE_NAME = "Emo.prefs"

    val pref: SharedPreferences = application.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)

    val editor = pref.edit()

    // /////////////////////////////////////////////////////////////////////////////////////////////
    // Get/Set Primitives (Int, String, Float, etc.) prefs. Uses pref and editor
    // /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Fetch a string value.
     */
    @Suppress("unused")
    fun get (name: String): String {
        return pref.getString(name, "")!!
    }

    /**
     * Save a string.
     */
    @Suppress("unused")
    fun put (name: String, value: String) {
        editor.putString(name, value)
        editor.commit()
    }

    /**
     * Fetch a boolean value.
     */
    fun getBool (name: String): Boolean {
        return pref.getBoolean(name, false)
    }

    /**
     * Save a boolean value.
     */
    fun putBool (name: String, value: Boolean) {
        editor.putBoolean(name, value)
        editor.commit()
    }

    /**
     * Fetch an int value.
     */
    fun getInt (name: String): Int {
        return getInt (name, 0)
    }

    /**
     * Fetch an int value.
     */
    fun getInt (name: String, def: Int): Int {
        return pref.getInt(name, def)
    }

    /**
     * Save an int.
     */
    fun putInt (name: String, value: Int) {
        editor.putInt(name, value)
        editor.commit()
    }

    /**
     * Stow away an array.
     */
    fun putIntArray (name: String, value: Array<Int>) {
        putInt (name, value.size)
        var pos=0
        for (item in value.iterator()) {
            editor.putInt(name+pos, item)
            editor.commit()
            pos++
        }
    }

    /**
     * Stow away an array.
     */
    fun putArray (name: String, value: Array<String>) {
        putInt (name, value.size)
        var pos=0
        for (item in value.iterator()) {
            editor.putString(name+pos, item.toString())
            editor.commit()
            pos++
        }
    }

    /**
     * Get an array.
     */
    fun getArray (name: String): Array<String> {
        val size = getInt (name)
        val value: Array<String> = Array (size) { "" }
        var pos=0
        for (item in value.iterator()) {
            value[pos] = get (name+pos)
            pos++
        }
        return value
    }

    /**
     * Fetch an int value.
     */
    fun getFloat (name: String): Float {
        return pref.getFloat(name, 1.0F)
    }

    /**
     * Save a string.
     */
    fun putFloat (name: String, value: Float) {
        editor.putFloat(name, value)
        editor.commit()
    }
}