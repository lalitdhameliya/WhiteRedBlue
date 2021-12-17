package com.application.whiteredblue.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.GridLayoutManager
import com.application.whiteredblue.R
import kotlinx.android.synthetic.main.activity_task1.*

class Task1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        btnSubmit.setOnClickListener {
            generateBoard()
        }
    }

    /**
     * This method is used to generate the board.
     */
    private fun generateBoard() {
        val num = Integer.parseInt(etNumber.text.toString())
        val list = mutableListOf<RedBlueModel>()

        for (index in 0..num){
            list.add(RedBlueModel(0))
        }

        rvRedBLue.adapter = RedBlueAdapter(list)
        rvRedBLue.layoutManager = GridLayoutManager(this@Task1, 3)

        Handler(Looper.getMainLooper()).postDelayed({
            val index = (0..list.size).random()
            list[index].currentMode=1
        }, 2000)
    }
}