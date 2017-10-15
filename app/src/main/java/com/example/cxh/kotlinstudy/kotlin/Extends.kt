package com.example.cxh.kotlinstudy.kotlin

import android.content.Context
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.Toast

/**
 * 扩展函数，包级函数
 */
//Context:扩展函数的所属对象
//. :扩展函数修饰符
//toast：扩展函数的名称
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun View.snackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}

fun View.snackbar(messageRes: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, messageRes, duration).show()
}

fun Any.log(message: String) {
    Log.e(this.javaClass.simpleName, message)
}

inline fun <reified T> T.logcat(log: Any) {
    Log.e(T::class.simpleName, log.toString())
}