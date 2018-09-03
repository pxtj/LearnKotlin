package com.porify.kotlin.Reflect

import com.porify.kotlin.joinToString
import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {
}

private fun StringBuilder.serializeObject(obj: Any){
    val kClass = obj.javaClass.kotlin
    val properties = kClass.memberProperties
}