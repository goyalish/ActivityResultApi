package com.example.activityresultapidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.invoke
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fetchDataFromSecondActivity = registerForActivityResult(SecondActivityContract()) { data ->
        tv_result_second_activity.text = data ?: getString(R.string.entered_nothing)
        tv_result_second_activity.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btn_launch_second_activity.setOnClickListener {
            fetchDataFromSecondActivity.invoke("Test Input")
        }

        btn_launch_third_activity.setOnClickListener {
            fetchDataFromThirdActivity()
        }

        btn_capture.setOnClickListener {
            capturePhoto.invoke(null)
        }
        btn_permission.setOnClickListener {
            //askLocationPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            askMultiplePermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_WIFI_STATE))
        }
    }

    private val fetchDataFromThirdActivity = registerForActivityResult(ThirdActivityContract()) { data ->
        tv_result_third_activity.text = data ?: getString(R.string.entered_nothing)
        tv_result_third_activity.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
    }

    private val capturePhoto = registerForActivityResult(ActivityResultContracts.TakePicture()) {bitmap ->
        iv_capture.setImageBitmap(bitmap)
        iv_capture.visibility = View.VISIBLE
    }

    private val askLocationPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        if(result){
            Log.e("TAG", "permnission granted")
        }else{
            Log.e("TAG", "No permnission")
        }
    }

    private val askMultiplePermissions = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {map : MutableMap<String, Boolean> ->
        for (entry in map.entries)
        {
            Toast.makeText(this, "${entry.key} = ${entry.value}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        fetchDataFromSecondActivity.unregister()
    }
}
