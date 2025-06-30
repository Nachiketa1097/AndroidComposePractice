package com.example.androidcomposepractice.study.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.androidcomposepractice.ui.theme.AndroidComposePracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LifecycleActivity : ComponentActivity() {
    private lateinit var name: String
    private lateinit var email: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = "kamal singh"
        email = "nachiketa1097@gmail.com"
        enableEdgeToEdge()
        setContent {
            AndroidComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        text = "First Activity screen ${savedInstanceState?.getString(USER_EMAIL)}",
                        modifier = Modifier
                            .padding(innerPadding)
                            .clickable {
                                val i = Intent(this, LifecycleActivity2::class.java)
                                startActivity(i)

                            })
                }
            }
        }

        //This is used when you press back show a alert of Are you sure you want to exit?
//        onBackPressedDispatcher.addCallback(this) {
//            showExitDialog()
//        }
        Log.d("ACTIVITY_LIFECYCLE", "First onCreate")
    }

    private fun showExitDialog() {
        AlertDialog.Builder(this)
            .setTitle("Exit App")
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                finishAffinity()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("ACTIVITY_LIFECYCLE", "First onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ACTIVITY_LIFECYCLE", "First onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ACTIVITY_LIFECYCLE", "First onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ACTIVITY_LIFECYCLE", "First onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ACTIVITY_LIFECYCLE", "First onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ACTIVITY_LIFECYCLE", "First onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(USER_NAME, name)
        outState.putString(USER_EMAIL, email)
    }

    companion object {
        const val USER_NAME = "user_name"
        const val USER_EMAIL = "user_email"
    }
}