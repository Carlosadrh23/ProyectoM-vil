package com.example.proyectoairbnbmovil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val etEditName = findViewById<EditText>(R.id.etEditName)
        val etEditEmail = findViewById<EditText>(R.id.etEditEmail)
        val btnSaveProfile = findViewById<Button>(R.id.btnSaveProfile)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        val btnSaved = findViewById<ImageButton>(R.id.btnSaved)
        val btnMessages = findViewById<ImageButton>(R.id.btnMessages)

        btnSaveProfile.setOnClickListener {
            val name = etEditName.text.toString().trim()
            val email = etEditEmail.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Perfil actualizado", Toast.LENGTH_SHORT).show()
            finish()
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