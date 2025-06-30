package com.example.androidcomposepractice.study.activity.launchmode

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class LaunchModeMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LAUNCH_MODE", "MainActivity created: ${this.hashCode()}")
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Main Activity", fontSize = 20.sp)
                LaunchModeButton("Start Standard Activity") {
                    startActivity(Intent(this@LaunchModeMainActivity, StandardActivity::class.java))
                }
                LaunchModeButton("Start SingleTop Activity") {
                    startActivity(Intent(this@LaunchModeMainActivity, SingleTopActivity::class.java))
                }
                LaunchModeButton("Start SingleTask Activity") {
                    startActivity(Intent(this@LaunchModeMainActivity, SingleTaskActivity::class.java))
                }
                LaunchModeButton("Start SingleInstance Activity") {
                    startActivity(Intent(this@LaunchModeMainActivity, SingleInstanceActivity::class.java))
                }
            }
        }
    }
}
