package com.example.cxh.kotlinstudy.activity

import android.graphics.Color
import android.os.Bundle
import com.example.cxh.kotlinstudy.R
import com.example.cxh.kotlinstudy.kotlin.kt09_singleton.debug11
import com.example.cxh.kotlinstudy.kotlin.kt09_singleton.log
import com.example.cxh.kotlinstudy.kotlin.kt09_singleton.snackbar
import com.example.cxh.kotlinstudy.kotlin.kt09_singleton.toast
import com.example.cxh.kotlinstudy.util.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.error
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() {

    //companion object是在类加载的时候初始化的，相当于java中的静态内部类（kotlin没有static关键字）
    //伴生对象里可存放常量、方法
    companion object {
        val GITHUB_URL = "https://github.com/KobeBryant824"
    }

    private var nameList: ArrayList<String> = arrayListOf("a", "b", "c")
    private lateinit var name: String // 懒、延迟初始化
    private val sex: String by lazy {
        //可以延迟到一定实际再使用并初始化的 final 变量，这在 Java 中是做不到的
        nameList[0]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "Hello, Kotlin！"
        textView.textSize = 24f
        textView.setTextColor(Color.parseColor("#303F9F"))
        textView.snackbar("Hello, Kotlin!")

        start.setOnClickListener {
            startActivity<AnkoActivity>("id" to 5)
            toast("go,anko")
            start.snackbar("go,anko")
            log("go,anko")
        }

        var value: String? // ？显示声明字段可为空，反之
//        value.length // 编译错误
        value = "def"
        val length: Int = value.length
        error(length)

        debug11("hhhhhhhhhh")

        //Coroutine协程
        launch(CommonPool) {
            // create new coroutine in common thread pool
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main function continues while coroutine is delayed
        Thread.sleep(2000L)

        KotlinSingleton.getInstance()

    }

}
