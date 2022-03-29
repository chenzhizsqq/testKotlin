package com.example.testkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testkotlin.databinding.ActivityTemplateBinding


class TemplateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemplateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.normal.setOnClickListener { test_T() }
        binding.addNumbersTest.setOnClickListener { test_fun_T() }

        binding.test2.setOnClickListener { Log.e(TAG, "T函数_返回为指定类型的函数: " + fun_T_return_other_T(10)) }

        binding.test3.setOnClickListener { fun_T_return_other_T_inFun(123.456) }

        binding.testAny.setOnClickListener {
            泛型函数_any(123)
            泛型函数_any("abc")
        }

        binding.checkStyle.setOnClickListener {
            函数内判断类型(MutableList(1) { 0 })
            函数内判断类型(Array(1) { 2 })
            函数内判断类型(123)
            函数内判断类型("str")
        }

    }

    fun 函数内判断类型(a: Any) {
        when (a) {
            is MutableList<*> -> {
                Log.e(TAG, "函数内判断类型: is MutableList")
            }
            is Array<*> -> {
                Log.e(TAG, "函数内判断类型: is array")
            }
            is Int -> {
                Log.e(TAG, "函数内判断类型: is Int")
            }
            is String -> {
                Log.e(TAG, "函数内判断类型: is String")
            }
        }
    }

    //泛型函数_函数内指定返回的类型_返回值
    fun <T> fun_T_return_other_T(t: T): Int {
        return t.toString().toInt()
    }

    //泛型函数_函数内指定返回的类型_函数内
    fun <T> fun_T_return_other_T_inFun(t: T) {
        Log.e(TAG, "泛型函数_函数内指定返回的类型: " + t.toString().toDouble())
    }

    //泛型函数_any
    fun 泛型函数_any(any: Any) {
        Log.e(TAG, "addNumbers4: $any")
    }

    //泛型函数 begin
    fun <T> fun_T(num1: T, num2: T): T {
        return (num1.toString().toDouble() + num2.toString().toDouble()) as T
    }

    fun test_fun_T() {
        Log.e(TAG, "addNumbersTest: " + fun_T(10, 20))      // 結果: 30
        Log.e(TAG, "addNumbersTest: " + fun_T(10.1, 20.1))  // 結果: 30.200000000000003
    }
    //泛型函数 end

    private fun test_T() {
        class Box<T>(val contents: T)

        val x = Box("a")
        val y = Box(0)
        val z = Box(listOf(1, 2, 3))


        Log.e(TAG, "contents: " + x.contents + "bc")   //abc
        Log.e(TAG, "contents: " + y.contents + 1)     //1
        z.contents.forEach {
            Log.e(TAG, "contents: " + it)
        }   //123


        val testUnit = Box(Unit)
        Log.e(TAG, "testUnit: " + testUnit.contents )   //kotlin.Unit
    }

    companion object {
        const val TAG = "TemplateActivity"
    }
}