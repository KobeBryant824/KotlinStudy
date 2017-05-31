package com.example.cxh.kotlinstudy.activity

import android.graphics.Color
import android.os.Bundle
import com.example.cxh.kotlinstudy.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.error
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "你好，Kotlin！"
        textView.textSize = 24f
        textView.setTextColor(Color.parseColor("#303F9F"))

        start.setOnClickListener {
            startActivity<AnkoActivity>("id" to 5)
        }

        var value: String? // ？显示声明字段可为空，反之
//        value.length // 编译错误
        value = "def"
        val length: Int = value.length
        error(length)

    }

}
