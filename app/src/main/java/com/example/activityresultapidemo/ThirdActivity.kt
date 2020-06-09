package com.example.activityresultapidemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activityresultapidemo.constants.DATA_THIRD_ACTIVITY
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        supportActionBar?.title = getString(R.string.third_activity)
        supportFragmentManager.beginTransaction().add(R.id.fl_child, MyFragment()).commit()
        processData()
    }

    private fun processData() {
        btn_send_data.setOnClickListener {
            val data = if (et_input_data.text.isNullOrEmpty()) getString(R.string.entered_nothing)
            else et_input_data.text.toString()
            setResult(Activity.RESULT_OK, Intent().putExtra(DATA_THIRD_ACTIVITY, data))
            finish()
        }
    }
}
