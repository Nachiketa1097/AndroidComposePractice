package com.example.androidcomposepractice.study.activity.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SingleTopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAUNCH_MODE", "SingleTopActivity created: ${this.hashCode()}")
        setContent {
            ActivityScreen("SingleTopActivity", this)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("LAUNCH_MODE", "SingleTopActivity onNewIntent: ${this.hashCode()}")
    }
}
