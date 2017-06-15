package com.example.cxh.kotlinstudy.kotlin.kt03_console_param


fun main(args: Array<String>): Unit {
    args.map { println(it) } // map()形参传递一个lambda表达式，println()传递it返回unit
    args.map(::println) // 如果是个lambda表达式就可以直接传递方法引用
}
