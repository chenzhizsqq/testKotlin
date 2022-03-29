package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class OpenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open)

        testOpen()
    }

    open class Cat : Animal("猫") {
        override fun cry() {
            Log.e(TAG, "ニャー！")
        }
    }

    open class Dog : Animal("犬") {
        override fun cry() {
            Log.e(TAG, "ワンワン！", )
        }
    }

    open class TestOpen : Animal("TestOpen")

    private fun testOpen() {
        Animal("動物").greet()  // 私は動物です。ウー！
        Cat().greet()  // 私は猫です。ニャー！
        Dog().greet()  // 私は犬です。ワンワン！
        TestOpen().greet()
    }

    companion object{
        const val TAG = "OpenActivity"
    }
}

open class Animal(val name: String) {
    fun greet() {
        Log.e("Animal", "私は${name}です。" )
        cry()
    }
    open fun cry() {
        Log.e("Animal", "open class cry()！", )
    }
}