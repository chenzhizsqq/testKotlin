package com.example.testkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

//https://www.cnblogs.com/Jetictors/p/8183254.html
class AbstractClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abstract_class)


        // val lanauage = Lanauage() 是错误的，因为抽象类不能直接被实例化

        val mTestAbstarctA = TestAbstarctA()
        val mTestAbstarctB = TestAbstarctB()

        Log.e("TAG", "mTestAbstarctA.name: " + mTestAbstarctA.name)
        mTestAbstarctA.init()

        println(mTestAbstarctB.name)
        Log.e("TAG", "mTestAbstarctB.name: " + mTestAbstarctB.name)
        mTestAbstarctB.init()
    }
}

abstract class Lanauage {
    val TAG = this.javaClass.simpleName  // 自身的属性

    // 自身的函数
    fun test(): Unit {
        // exp
    }

    abstract var name: String           // 抽象属性
    abstract fun init()                  // 抽象方法
}

/**
 * 抽象类Lanauage的实现类TestAbstarctA
 */
class TestAbstarctA : Lanauage() {

    override var name: String
        get() = "Kotlin"
        set(value) {}

    override fun init() {
        Log.e(TAG, "init: 我是$name")
    }
}

/**
 * 抽象类Lanauage的实现类TestAbstarctB
 */
class TestAbstarctB : Lanauage() {
    override var name: String
        get() = "Java"
        set(value) {}

    override fun init() {
        Log.e(TAG, "init: 我是$name")
    }
}