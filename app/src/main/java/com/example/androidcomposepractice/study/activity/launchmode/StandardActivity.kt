package com.example.androidcomposepractice.study.activity.launchmode

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class StandardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAUNCH_MODE", "StandardActivity created: ${this.hashCode()}")
        setContent {
            ActivityScreen("StandardActivity", this)
        }
    }
}
