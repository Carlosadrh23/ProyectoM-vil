package com.example.proyectoairbnbmovil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val tvLogout = findViewById<TextView>(R.id.tvLogout)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        val btnSaved = findViewById<ImageButton>(R.id.btnSaved)
        val btnMessages = findViewById<ImageButton>(R.id.btnMessages)

        tvLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        btnSaved.setOnClickListener {
            startActivity(Intent(this, SavedActivity::class.java))
        }

        btnMessages.setOnClickListener {
            startActivity(Intent(this, MessagesActivity::class.java))
        }
    }
}