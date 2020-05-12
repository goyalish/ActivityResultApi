package com.example.activityresultapidemo

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import com.example.activityresultapidemo.constants.DATA
import com.example.activityresultapidemo.constants.DATA_THIRD_ACTIVITY

/**
 * Created by NiteshGoyal on 12/05/20.
 */
class SecondActivityContract : ActivityResultContract<Unit, String?>() {

    override fun createIntent(context: Context, input: Unit?): Intent {
        return Intent(context, SecondActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            RESULT_OK -> intent?.getStringExtra(DATA)
            else -> null
        }
    }
}

class ThirdActivityContract : ActivityResultContract<Unit, String?>() {

    override fun createIntent(context: Context, input: Unit?): Intent {
        return Intent(context, ThirdActivity::class.java)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return when (resultCode) {
            RESULT_OK -> intent?.getStringExtra(DATA_THIRD_ACTIVITY)
            else -> null
        }
    }
}