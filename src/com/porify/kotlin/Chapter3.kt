package com.porify.kotlin


fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 53)
    println(set.javaClass)
    println("$set")

    val list = arrayListOf(2, 4, 5)
    println(list.javaClass)
    println("$list")
    println("max: ${list.max()}")
    println("max: " + list.max())
    println(joinToStringWittDefault(list))

    val map = hashMapOf(1 to "one", 7 to "seven", 9 to "nine")
    println(map.javaClass)
    println("$map")

    val list2 = listOf(1, 2, 3)
    println(joinToString(list2, ";", "(", ")"))
    println(joinToString(list2, separator = ";", prefix = "(", postfix = ")"))

    println(joinToStringWittDefault(list2))
    println(joinToStringWittDefault(list2, "; "))

    val result = list2.joinToString("$$")
    println(result)

    println("Kotlin".lastChar2())
    println("Kotlin".lastChar)

    val (number, name) = 1 to "one"
    println("$number, $name")

    val string = "12.345-6.A"
    println(string)
    println(string.split("."))
    println(string.split('.', '-'))
    println(string.split("\\.|-"))
    println(string.split("\\.|-".toRegex()))

    println(parsePath("H:\\照片\\xiaoliu\\xl2\\xl\\lx\\xl\\xl.PNG", "\\"))
    println(parerPathByRegex("H:\\照片\\xiaoliu\\xl2\\xl\\lx\\xl\\xl.PNG", "\\"))


    val user = User(2, "", "")
    saveUser1(user)
    saveUser2(user)
    saveUser3(user)
    saveUser4(user)
}

fun <T> joinToString(collection: Collection<T>, separator: String,
                     prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
fun <T> joinToStringWittDefault(collection: Collection<T>, separator: String = ", ",
                     prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun String.lastChar(): Char = this.get(this.length - 1)
fun String.lastChar2(): Char = this[length - 1]
val String.lastChar: Char get() = get(length - 1)
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun parsePath(path: String, separator: String = "/") {
    val directory = path.substringBeforeLast(separator)
    val fullName = path.substringAfterLast(separator)
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name : $fileName, ext: $extension")
}

fun parerPathByRegex(path: String, separator: String = "/") {
    //val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val regex = """(.+)\\(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name : $fileName, ext: $extension")
    }
}