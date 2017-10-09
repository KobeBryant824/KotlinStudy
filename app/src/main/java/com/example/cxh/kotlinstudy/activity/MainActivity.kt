package com.example.cxh.kotlinstudy.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.example.cxh.kotlinstudy.R
import com.example.cxh.kotlinstudy.kotlin.snackbar
import com.example.cxh.kotlinstudy.kotlin.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "Hello Kotlin"
        textView.textSize = 24f
        textView.setTextColor(Color.parseColor("#303F9F"))
        textView.snackbar("Hello, Kotlin!")

        start.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id", 5)
            pushPage<AnkoActivity>(bundle)

//            startActivity<AnkoActivity>("id" to 5)
            toast("hello,anko")
        }

    }

}


