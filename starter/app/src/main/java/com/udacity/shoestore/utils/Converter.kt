package com.udacity.shoestore.utils

import androidx.databinding.InverseMethod

/** Converter class to convert size from string to double
 *
 * using Two-way data binding -> https://developer.android.com/topic/libraries/data-binding/two-way#converters
 */
object Converter {

    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(
        value: Double
    ): String {
        // Converts Double to String.
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(
        value: String
    ): Double {
        // Converts String to Double.
        return if (value.isNotEmpty())
            value.toDouble()
        else
            0.0
    }
}