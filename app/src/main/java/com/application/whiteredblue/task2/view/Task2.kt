package com.application.whiteredblue.task2.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.whiteredblue.R
import com.application.whiteredblue.task2.view.adapter.UsersAdapter
import com.application.whiteredblue.task2.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_task2.*
import kotlin.math.log

class Task2 : AppCompatActivity() {

    lateinit var context: Context
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task2)

        context = this@Task2
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.getUser()!!.observe(this, Observer { user ->
            progressBar.visibility = View.GONE
            Log.d("USER_RESPONSE", "USER RESPONSE: ${user.total}")

            rvUserList.adapter = UsersAdapter(user.data)
            rvUserList.layoutManager = LinearLayoutManager(context)
        })
    }
}