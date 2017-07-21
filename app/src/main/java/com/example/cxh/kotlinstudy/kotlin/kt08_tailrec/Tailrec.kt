package com.example.cxh.kotlinstudy.kotlin.kt08_tailrec

import java.math.BigInteger


class Result(var value: BigInteger = BigInteger.valueOf(1L))

// 尾递归 优化
tailrec fun factorial(num: Int, result: Result){
    if(num == 0) result.value = result.value.times(BigInteger.valueOf(1L))
    else {
        result.value = result.value.times(BigInteger.valueOf(num.toLong()))
        factorial(num - 1, result)
    }
}

fun main(args: Array<String>) {
    val result = Result()
    factorial(10, result)
    println(result.value)
}
