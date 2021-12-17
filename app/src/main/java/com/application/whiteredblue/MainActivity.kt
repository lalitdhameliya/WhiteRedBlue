package com.application.whiteredblue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.application.whiteredblue.task1.Task1
import com.application.whiteredblue.task2.view.Task2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTask1.setOnClickListener {
            startActivity(Intent(this@MainActivity, Task1::class.java))
        }

        btnTask2.setOnClickListener {
            startActivity(Intent(this@MainActivity, Task2::class.java))
        }
    }
}