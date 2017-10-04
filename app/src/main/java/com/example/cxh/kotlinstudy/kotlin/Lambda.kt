package com.example.cxh.kotlinstudy.kotlin

import io.reactivex.Observable
import io.reactivex.functions.Consumer


fun main(args: Array<String>) {
//    val text = "This reference is designed for you to easily learn Kotlin in a matter of hours. Start with the basic syntax, then proceed to more advanced topics. While reading, you can try out the examples in the online IDE. Once you get an idea of what Kotlin looks like, try yourself in solving some Kotlin Koans - interactive programming exercises. If you are not sure how to solve a Koan, or you're looking for a more elegant solution, check out Kotlin idioms."
    val text = "hhh   x  a"

    Observable
            .fromIterable(text.toCharArray().asIterable())
            .filter { !it.isWhitespace() } // 当Java函数的形参是个接口且只有一个抽象方法可以用lambda代替
            .groupBy { it }
            .subscribe {
                o ->
                o.count().subscribe(Consumer {  // 这里的subscribe（）有重载
                    println("${o.key} -> $it")
                })
            }
}




