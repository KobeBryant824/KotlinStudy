package com.example.cxh.kotlinstudy.activity

import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger

// abstract 也可以，默认为final，不可继承
open class BaseActivity : AppCompatActivity(),AnkoLogger {

}
