package com.example.cxh.kotlinstudy.kotlin.kt14_in_kotlin_u_java.kotlin

import java.util.*


//Kotlin 无法写出这样的代码，Kotlin的泛型是真泛型，没擦除，这样会陷入循环引用
//abstract class View<P : Presenter<out View<out Presenter<out View<out Presenter>>> {
//    protected abstract val presenter: P
//}
//
//abstract class Presenter<out V : View<out Presenter<out View>>>{
//    protected abstract val view: V
//}

fun main(args: Array<String>) {
    val list = ArrayList<Any>()
    list.add("Hello")
    list.add(0)
    list.map(::println)
}