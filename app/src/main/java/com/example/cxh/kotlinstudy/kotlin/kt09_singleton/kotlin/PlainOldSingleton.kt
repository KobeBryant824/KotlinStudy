package com.example.cxh.kotlinstudy.kotlin.kt09_singleton.kotlin

// 饿汉式
class PlainOldSingleton private constructor() {

    init {
        println("PlainOldSingleton")
    }

    companion object {
        val instance = PlainOldSingleton()
    }
}
