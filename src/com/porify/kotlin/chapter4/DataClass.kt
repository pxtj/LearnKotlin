package com.porify.kotlin.chapter4

import com.sun.org.apache.bcel.internal.generic.InstructionConstants

fun main(array: Array<String>) {
    val zhangSan = Client("zhangsan", 610000)
    println(zhangSan.toString())
    val client2 = Client("lisi", 610000)
    println(zhangSan == client2)
    val processed = hashSetOf(Client("zhangsan", 610000))
    println(processed.contains(zhangSan)) //override hashCode method
    println(zhangSan.copy(postCode = 756300))

    val hashSet = hashSetOf(1, 1, 2, 2, 3)
    println(hashSet)
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 2, 1, 2, 3))
    println("${cset.objectAdded} objects were added, ${cset.size} remain: $cset")
}

data class Client(val name: String, val postCode: Int)
class ClientNotData(val name: String, val postCode: Int) {
    override fun toString() = "Client($name, postCode = $postCode)"

    override fun equals(other: Any?) = when {
        other == null || other !is Client -> false
        (name == other.name && postCode == other.postCode) -> true
        else -> false
    }

    override fun hashCode() = name.hashCode() + 31 * postCode

    fun copy(name: String = this.name, postCode: Int = this.postCode) = ClientNotData(name, postCode)
}

//代理模式
// 通过by关键字将接口的实现委托给innerList对象
class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList

data class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>())
    : MutableCollection<T> by innerSet {
    var objectAdded = 0
        private set

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}





























