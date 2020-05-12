package com.example.activityresultapidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.invoke
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btn_launch_second_activity.setOnClickListener {
//            fetchDataFromSecondActivity.invoke()
            fetchDataFromSecondActivity()
        }
    }

    private val fetchDataFromSecondActivity = registerForActivityResult(MainActivityContract()) { data ->
        tv_result_second_activity.text = data
        tv_result_second_activity.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
    }
}
