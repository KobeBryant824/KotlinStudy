package com.example.cxh.kotlinstudy.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.jetbrains.anko.AnkoLogger

// abstract 也可以，默认为final，不可继承
open class BaseActivity : AppCompatActivity(), AnkoLogger

inline fun <reified T> T.logcat(log: Any) {
    Log.e(T::class.simpleName, log.toString())
}

inline fun <reified T : Activity> Activity.pushPage() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

inline fun <reified T : Activity> Activity.pushPage(bundle: Bundle) {
    val intent = Intent(this, T::class.java)
    intent.putExtras(bundle)
    startActivity(intent)
}

