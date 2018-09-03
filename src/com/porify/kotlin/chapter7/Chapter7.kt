package com.porify.kotlin.chapter7

import com.porify.kotlin.chapter4.loadFromJson


fun main(args: Array<String>) {

    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers)
    numbers += 43
    println(numbers)
    numbers.add(78)
    println(numbers)

    val (name, ext) = splitFileName("example.ke")
    println("name : $name, ext: $ext")

    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)

}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}

operator fun Point.minus(other: Point) = Point(x - other.x, y - other.y)

data class NameComponents(val name: String, val extension: String)

fun splitFileName(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}

fun splitFileName2(fullName: String): NameComponents {
    val (name, ext) = fullName.split('.', limit = 2)
    return NameComponents(name, ext)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

