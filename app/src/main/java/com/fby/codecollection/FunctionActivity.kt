package com.fby.codecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_function.*
import org.jetbrains.anko.toast

class FunctionActivity : AppCompatActivity() {
    val fuction = fun(_: View) {
        toast("成功传入方法")
    }

    fun test() {
        toast("成功传入方法1")
    }

    private fun test1(view: View) {
        toast("成功传入方法1")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)
        btn.setOnClickFunctionListener(fuction)
        btn.setOnClickFunctionListener { test() }
        btn1.setOnClickListener { test() }


    }


}
