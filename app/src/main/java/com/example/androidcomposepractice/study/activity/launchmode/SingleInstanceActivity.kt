package com.example.androidcomposepractice.study.activity.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class SingleInstanceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAUNCH_MODE", "SingleInstanceActivity created: ${this.hashCode()}")
        setContent {
            ActivityScreen("SingleInstanceActivity", this)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d("LAUNCH_MODE", "SingleInstanceActivity onNewIntent: ${this.hashCode()}")
    }
}
