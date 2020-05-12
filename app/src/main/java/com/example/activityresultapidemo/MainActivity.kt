package com.example.activityresultapidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.invoke
import androidx.activity.result.contract.ActivityResultContracts
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
//            fetchDataFromSecondActivity.invoke() can also be used
            fetchDataFromSecondActivity()
        }

        btn_launch_third_activity.setOnClickListener {
            fetchDataFromThirdActivity()
        }

        btn_capture.setOnClickListener {
            capturePhoto(null)
        }

    }

    private val fetchDataFromSecondActivity = registerForActivityResult(SecondActivityContract()) { data ->
        tv_result_second_activity.text = data ?: getString(R.string.entered_nothing)
        tv_result_second_activity.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
    }

    private val fetchDataFromThirdActivity = registerForActivityResult(ThirdActivityContract()) { data ->
        tv_result_third_activity.text = data ?: getString(R.string.entered_nothing)
        tv_result_third_activity.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
    }

    private val capturePhoto = registerForActivityResult(ActivityResultContracts.TakePicture()) {bitmap ->
        iv_capture.setImageBitmap(bitmap)
        iv_capture.visibility = View.VISIBLE
    }
}
