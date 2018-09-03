package com.porify.kotlin

fun <T> Collection<T>.joinToString(separator: String, prefix: String = "",
                                   postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun String?.isNullOrBlank() = this == null || this.isBlank()