package com.porify.kotlin.chapter7.proxy

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Worker(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

class Worker2(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    val _age = ObservableProperty(name, age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(newValue) {
            _age.setValue(newValue)
        }

    val _salary = ObservableProperty(name, salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(newValue) {
            _salary.setValue(newValue)
        }
}

class WorkByProxy(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int by ObservablePropertyByProxy(age, changeSupport)
    var salary: Int by ObservablePropertyByProxy(salary, changeSupport)
}

class WorkerByDelegate(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

class Person {
    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    //val name: String
    //get() = _attributes[name]!!
    val name: String by _attributes
}