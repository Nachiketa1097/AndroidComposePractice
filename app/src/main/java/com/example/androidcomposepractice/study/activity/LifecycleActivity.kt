package com.example.androidcomposepractice.study.activity

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.addCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.androidcomposepractice.ui.theme.AndroidComposePracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LifecycleActivity : ComponentActivity() {
    companion object {
        const val USER_NAME = "user_name"
        const val USER_EMAIL = "user_email"
    }

    private lateinit var name: String
    private lateinit var email: String

    var text: String = ""
    var image: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = "kamal singh"
        email = "nachiketa1097@gmail.com"

        enableEdgeToEdge()
        setContent {
            AndroidComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        Text(
                            text = "First Activity screen ${savedInstanceState?.getString(USER_EMAIL)}",
                            modifier = Modifier
                                .padding(innerPadding)
                                .clickable {
                                    val i = Intent(
                                        this@LifecycleActivity,
                                        LifecycleActivity2::class.java
                                    )
                                    startActivity(i)
                                }
                        )

                        Text("Shared Text: $text")

                        image?.let {
                            Image(
                                painter = rememberAsyncImagePainter(it),
                                contentDescription = null,
                                modifier = Modifier.size(200.dp)
                            )
                        }
                    }
                }
            }
        }
        /*This is used when you press back show a alert of Are you sure you want to exit?*/
        onBackPressedDispatcher.addCallback(this) {
            showExitDialog()
        }
        Log.d("ACTIVITY_LIFECYCLE", "First onCreate")
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

    //Here accept any data shared by another app
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIncomingShare(intent)
    }

    private fun handleIncomingShare(intent: Intent) {
        when (intent.action) {
            Intent.ACTION_SEND -> {
                when (intent.type) {
                    "text/plain" -> {
                        val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
                        Log.d("ACTIVITY_LIFECYCLE", "sharedText $sharedText")
                        sharedText?.let {
                            text = it
                        }
                    }

                    "image/*" -> {
                        val imageUri = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
                        imageUri?.let {
                            image = it
                        }
                    }
                }
            }
        }
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
}