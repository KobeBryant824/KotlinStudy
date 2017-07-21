package com.example.cxh.kotlinstudy.kotlin.kt09_singleton.kotlin


class LazyThreadSafeStaticInnerObject private constructor(){
    companion object{
        fun getInstance() = Holder.instance
    }

    private object Holder{
        val instance = LazyThreadSafeStaticInnerObject()
    }
}