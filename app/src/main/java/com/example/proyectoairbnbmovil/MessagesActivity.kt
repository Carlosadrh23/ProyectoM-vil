package com.example.proyectoairbnbmovil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Message(
    val name: String,
    val lastMessage: String,
    val time: String,
    val unread: Int,
    val avatarColor: String,
    val initials: String
)

class MessagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val rvMessages = findViewById<RecyclerView>(R.id.rvMessages)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        val btnSaved = findViewById<ImageButton>(R.id.btnSaved)

        val messages = listOf(
            Message("Sofia R.", "¡Bienvenido! El código de acces...", "10:32", 2, "#4A90D9", "SR"),
            Message("Miguel G.", "Claro, el check-in es a las 3 p. m.", "Ayer", 0, "#7ED321", "MG"),
            Message("Ana L.", "¿Necesitas más toallas? Con g...", "Lun", 0, "#9B59B6", "AL"),
            Message("Roberto V.", "Gracias por tu estancia, espero...", "Dom", 0, "#F5A623", "RV"),
            Message("Carmen H.", "Perfecto te espero a las 2 p. m.", "Sáb", 0, "#E74C3C", "CH")
        )

        rvMessages.layoutManager = LinearLayoutManager(this)
        rvMessages.adapter = MessagesAdapter(messages)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        btnSaved.setOnClickListener {
            startActivity(Intent(this, SavedActivity::class.java))
        }
    }
}