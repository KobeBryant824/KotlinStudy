package com.example.cxh.kotlinstudy.activity

import android.graphics.Color
import android.os.Bundle
import com.example.cxh.kotlinstudy.R
import com.example.cxh.kotlinstudy.kotlin.snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "Hello Kotlin"
        textView.textSize = 24f
        textView.setTextColor(Color.parseColor("#303F9F"))
        textView.snackbar("Hello, Kotlin!")

        start.onClick {
            startActivity<AnkoActivity>("id" to 5)
        }
    }

}


