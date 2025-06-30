package com.example.androidcomposepractice.study.activity.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SingleTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAUNCH_MODE", "SingleTaskActivity created: ${this.hashCode()}")
        setContent {
            ActivityScreen("SingleTaskActivity", this)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("LAUNCH_MODE", "SingleTaskActivity onNewIntent: ${this.hashCode()}")
    }
}
