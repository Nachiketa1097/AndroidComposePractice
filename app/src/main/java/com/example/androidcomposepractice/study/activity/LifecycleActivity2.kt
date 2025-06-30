package com.example.androidcomposepractice.study.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.androidcomposepractice.ui.theme.AndroidComposePracticeTheme

class LifecycleActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(text = "Second Activity screen", modifier = Modifier.padding(innerPadding))
                }
            }
        }
        Log.d("ACTIVITY_LIFECYCLE", "Second onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("ACTIVITY_LIFECYCLE", "Second onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ACTIVITY_LIFECYCLE", "Second onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ACTIVITY_LIFECYCLE", "Second onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ACTIVITY_LIFECYCLE", "Second onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ACTIVITY_LIFECYCLE", "Second onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ACTIVITY_LIFECYCLE", "Second onDestroy")
    }
}