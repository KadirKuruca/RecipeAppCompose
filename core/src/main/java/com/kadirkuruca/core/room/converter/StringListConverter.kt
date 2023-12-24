package com.kadirkuruca.core.room.converter

import androidx.room.TypeConverter
import com.kadirkuruca.core.extension.fromJson
import com.kadirkuruca.core.extension.toJson

class StringListConverter {
    @TypeConverter
    fun toListOfStrings(stringValue: String): List<String>? {
        return stringValue.fromJson()
    }

    @TypeConverter
    fun fromListToStrings(listOfStrings: List<String>?): String {
        return listOfStrings.toJson()
    }
}