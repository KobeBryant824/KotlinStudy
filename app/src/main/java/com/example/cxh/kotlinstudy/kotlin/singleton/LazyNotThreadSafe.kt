package com.example.cxh.kotlinstudy.kotlin.singleton


class LazyNotThreadSafe {

    companion object{
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            LazyNotThreadSafe()
        }

        //下面是另一种等价的写法, 获取单例使用 get 方法
        private var instance2: LazyNotThreadSafe? = null

        fun get() : LazyNotThreadSafe {
            if(instance2 == null){
                instance2 = LazyNotThreadSafe()
            }
            return instance2!!
        }
    }
}