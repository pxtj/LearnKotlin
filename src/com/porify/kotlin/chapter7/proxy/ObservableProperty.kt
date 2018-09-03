package com.porify.kotlin.chapter7.proxy

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty


class ObservableProperty(val proName: String, var proValue: Int,
                         val changeSupport: PropertyChangeSupport) {
    fun getValue(): Int = proValue
    fun setValue(newValue: Int) {
        val oldValue = proValue
        proValue = newValue
        changeSupport.firePropertyChange(proName, oldValue, newValue)
    }
}

class ObservablePropertyByProxy(var proValue: Int, val changeSupport: PropertyChangeSupport) {
    operator fun getValue(p: WorkByProxy, prop: KProperty<*>): Int = proValue
    operator fun setValue(w: WorkByProxy, prop: KProperty<*>, newValue: Int) {
        val oldValue = proValue
        proValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}