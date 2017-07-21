package com.example.cxh.kotlinstudy.kotlin.kt09_singleton.java;

// 单例2
public class LazyThreadSafeSynchronized {
    private static LazyThreadSafeSynchronized INSTANCE;

    private LazyThreadSafeSynchronized(){}

    public static synchronized LazyThreadSafeSynchronized getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyThreadSafeSynchronized();
        }
        return INSTANCE;
    }
}
