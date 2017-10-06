package com.example.cxh.kotlinstudy.activity

import android.os.Bundle
import com.example.cxh.kotlinstudy.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onLongClick
import java.net.URL


class AnkoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extra = intent.getIntExtra("id", 0)

        doAsync {
            logcat { Thread.currentThread().name }
            val readText = URL("https://www.baidu.com/").readText()
            logcat { readText }
            uiThread { longToast("hahaha" + readText) }
        }

        verticalLayout {
            padding = dip(20)
            textView("$extra")

            val name = editText() {
                textSize = 20f
                textColor = R.color.colorPrimary
                hint = "name"
            }


            button("Say Hello") {
                onClick { toast("Hello, ${name.text}!") }
            }.lparams(width = wrapContent) {
                leftMargin = dip(10)
                topMargin = dip(10)
            }


            themedButton("LongClick", theme = R.style.AppTheme) {
                onLongClick { toast("Hello, Kotlin!") }
            }


            linearLayout {
                button("Login") {
                    textSize = 26f
                    onClick {
                        alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
                            yesButton { toast("Oh…") }
                            noButton {}
                        }.show()
                    }
                }.lparams(width = wrapContent) {
                    horizontalMargin = dip(25) // 左右margin
                    topMargin = dip(10)
                }

                button("Register") {
                    textSize = 26f
                    onClick {
                        alert(Appcompat, "Some text message").show()
                    }
                }.lparams(width = wrapContent) {
                    topMargin = dip(10)
                }
            }

            val ID_OK = 1
            relativeLayout {
                button("Ok") {
                    id = ID_OK
                    onClick {
                        val countries = listOf("Russia", "USA", "Japan", "Australia")

//                        selector("Where are you from?", countries, { i ->
//                            toast("So you're living in ${countries[i]}, right?")
//                        })
                    }
                }.lparams { alignParentTop() }

                button("Cancel") {
                    onClick {
                        val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
                        dialog.show()
                    }
                }.lparams { below(ID_OK) }
            }
        }

    }
}
