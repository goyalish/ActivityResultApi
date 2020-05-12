package com.example.activityresultapidemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.activityresultapidemo.constants.DATA
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.title = getString(R.string.second_activity)
        processData()
    }

    private fun processData() {
        btn_send_data.setOnClickListener {
            val data = if (et_input_data.text.isNullOrEmpty()) "You did not enter anything"
            else et_input_data.text.toString()
            setResult(Activity.RESULT_OK, Intent().putExtra(DATA, data))
            finish()
        }
    }
}
