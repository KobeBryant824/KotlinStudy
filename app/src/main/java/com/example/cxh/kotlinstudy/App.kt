package com.example.cxh.kotlinstudy

import android.app.Application
import android.app.Fragment
import android.content.Context
import android.widget.Toast
import org.jetbrains.anko.AnkoContext

/**
 * Desc:
 * Created by Hai (haigod7@gmail.com) on 2017/5/27 14:12.
 */
class App : Application() {
    lateinit var mInstance:Context

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    fun getInstance() = mInstance
}
