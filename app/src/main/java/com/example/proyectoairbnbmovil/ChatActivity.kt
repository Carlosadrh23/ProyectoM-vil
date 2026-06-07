package com.example.proyectoairbnbmovil

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val tvChatName = findViewById<TextView>(R.id.tvChatName)
        val rvChat = findViewById<RecyclerView>(R.id.rvChat)
        val etChatMessage = findViewById<EditText>(R.id.etChatMessage)
        val btnMic = findViewById<ImageButton>(R.id.btnMic)

        val contactName = intent.getStringExtra("name") ?: "Contacto"
        tvChatName.text = contactName

        val messages = mutableListOf(
            ChatMessage("Hola, bienvenido!", false),
            ChatMessage("Gracias!", true),
            ChatMessage("El check-in es a las 3 p.m.", false),
            ChatMessage("Perfecto, ahí estaré", true),
            ChatMessage("Cualquier duda me avisas", false)
        )

        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        rvChat.layoutManager = layoutManager
        rvChat.adapter = ChatAdapter(messages)

        btnMic.setOnClickListener {
            val text = etChatMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                messages.add(ChatMessage(text, true))
                rvChat.adapter?.notifyItemInserted(messages.size - 1)
                rvChat.scrollToPosition(messages.size - 1)
                etChatMessage.text.clear()
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}