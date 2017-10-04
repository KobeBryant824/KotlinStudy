package com.example.cxh.kotlinstudy.kotlin.singleton


class LazyThreadSafeDoubleCheck private constructor() {
    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LazyThreadSafeDoubleCheck()
        }

        // 写法2
        private @Volatile var instance2: LazyThreadSafeDoubleCheck? = null

        fun get(): LazyThreadSafeDoubleCheck {
            if (instance2 == null) {
                synchronized(this) {
                    if (instance2 == null)
                        instance2 = LazyThreadSafeDoubleCheck()
                }
            }
            return instance2!!
        }
    }
}