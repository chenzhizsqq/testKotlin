package com.example.testkotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SealedClassActivity.setOnClickListener {
            val intent =
                Intent(this@MainActivity, SealedClassActivity::class.java)
            startActivity(intent)
        }

        binding.AbstractClassActivity.setOnClickListener {
            val intent =
                Intent(this@MainActivity, AbstractClassActivity::class.java)
            startActivity(intent)
        }

        binding.TemplateActivity.setOnClickListener {
            val intent =
                Intent(this@MainActivity, TemplateActivity::class.java)
            startActivity(intent)
        }

        binding.OpenActivity.setOnClickListener {
            val intent =
                Intent(this@MainActivity, OpenActivity::class.java)
            startActivity(intent)
        }


    }
}