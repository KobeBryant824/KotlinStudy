package com.example.cxh.kotlinstudy.kotlin.kt04_map_flatmap


fun main(vararg args: String) { // vararg 可变参数
    args.flatMap {
        it.split("_")
    }.map {
        print("$it${it.length}  ")
    }
}