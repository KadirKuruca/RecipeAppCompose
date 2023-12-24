package com.kadirkuruca.breathingapp.app.pref

import android.content.Context
import android.content.SharedPreferences

/**
 * @param fileName Name of the Shared Preferences
 * @return SharedPreferences
 */
fun Context.getPrefs(fileName: String? = null): SharedPreferences {
    val name = if (fileName.isNullOrEmpty()) {
        getDefaultSharedPrefName()
    } else {
        fileName.toString()
    }

    return this.getSharedPreferences(name, 0)
}

/**
 * @return Default SharedPreferences filename
 */
fun Context.getDefaultSharedPrefName(): String {
    return this.packageName + "_pref"
}