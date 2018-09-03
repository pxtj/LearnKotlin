package com.porify.kotlin.chapter7.proxy

import java.beans.PropertyChangeListener


fun main(args: Array<String>) {
    val w = Worker("Dmity", 30, 12000)
    w.addPropertyChangeListener(
            PropertyChangeListener { evt ->
                println("Property ${evt.propertyName} changed" +
                        "from ${evt.oldValue} to ${evt.newValue}")
            }
    )
    w.age = 36
    w.salary = 15000

    val worker2 = Worker2("Jack", 35, 20000)
    worker2.addPropertyChangeListener(
            PropertyChangeListener { evt ->
                println("Worker2 Property ${evt.propertyName} changed" +
                        "from ${evt.oldValue} to ${evt.newValue}")
            }
    )
    worker2.age = 40
    worker2.salary = 25000

    val worByProxy = WorkByProxy("Bob", 23, 10000)
    worByProxy.addPropertyChangeListener(
            PropertyChangeListener { evt ->
                println("WorkerByProxy Property ${evt.propertyName} changed" +
                        "from ${evt.oldValue} to ${evt.newValue}")
            }
    )

    worByProxy.age = 27
    worByProxy.salary = 26000

    val workerByDelegate = WorkerByDelegate("Trump", 26, 13456)
    workerByDelegate.addPropertyChangeListener(
            PropertyChangeListener { evt ->
                println("WorkerByDelegate Property ${evt.propertyName} changed" +
                        "from ${evt.oldValue} to ${evt.newValue}")
            }
    )
    workerByDelegate.age = 29
    workerByDelegate.salary = 30000

}