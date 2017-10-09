package com.example.cxh.kotlinstudy.kotlin

fun main(args: Array<String>) {
    Direction.values().forEach { println("${it.name} ${it.ordinal}") }
}

//更在意数据，可以提升代码表现力，但也会有性能开销，安卓建议用常量
enum class Direction {
    TOP, BOTTOM, LEFT, RIGHT
}