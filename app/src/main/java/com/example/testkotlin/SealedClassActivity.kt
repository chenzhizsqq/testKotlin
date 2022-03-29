package com.example.testkotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

//https://blog.csdn.net/huo108/article/details/80544645
class SealedClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sealed_class)


        val ec1: Mathematics = Mathematics.Dou(5.0)
        val d1 = ec1.eval(ec1)
        Log.e("TAG", "d1: $d1")

        val ec2: Mathematics = Mathematics.Sub(ec1, Mathematics.Dou(3.0))
        val d2 = ec2.eval(ec2)
        Log.e("TAG", "d2: $d2")

        val ec3: Mathematics = Mathematics.NotANumber
        val d3 = ec3.eval(ec3)
        Log.e("TAG", "d3: $d3")
    }
}

sealed class Mathematics {
    data class Dou(val number: Double) : Mathematics()
    data class Sub(val e1: Mathematics, val e2: Mathematics) : Mathematics()
    object NotANumber : Mathematics()

    fun eval(m: Mathematics): Double = when (m) {
        is Dou -> {
            m.number
        }
        is Sub -> {
            eval(m.e1) - eval(m.e2)
        }
        is NotANumber -> {
            Double.NaN
        }
    }
}