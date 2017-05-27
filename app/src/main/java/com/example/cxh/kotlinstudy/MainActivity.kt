package com.example.cxh.kotlinstudy

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "你好"
        textView.textSize = 24f
        textView.setTextColor(R.color.colorAccent)

        start.setOnClickListener {
            toast("Hello, Kotlin!")
//            toast("开始")
//            startActivity<AnotherActivity>()
        }
    }

    fun Context.toast(message: String, duration:Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }
}
