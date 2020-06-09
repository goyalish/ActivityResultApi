package com.example.activityresultapidemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.invoke
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_myfragment.*

/**
 * Created by NiteshGoyal on 24/05/20.
 */
class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_myfragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_get_data.setOnClickListener {
            fetchDataFromSecondActivity("Calling from fragment")
        }
    }
    private val fetchDataFromSecondActivity = registerForActivityResult(SecondActivityContract()) { data ->
        tv_result.text = data
    }
}