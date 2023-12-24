package com.kadirkuruca.core.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

val gson = Gson()

inline fun<reified T> String.fromJson(): T? {
    return try {
        gson.fromJson(this, T::class.java)
    } catch (ex: Exception) {
        null
    }
}

inline fun<reified T> String.fromJsonList(): List<T>? {
    return try {
        val collectionType: Type = object : TypeToken<List<T>?>() {}.type
        gson.fromJson(this, collectionType)
    } catch (ex: Exception) {
        null
    }
}

inline fun<reified T> T.toJson(): String {
    return try {
        gson.toJson(this)
    } catch (ex: Exception) {
        ""
    }
}