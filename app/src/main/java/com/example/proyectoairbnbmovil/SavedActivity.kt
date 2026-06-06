package com.example.proyectoairbnbmovil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SavedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val rvSaved = findViewById<RecyclerView>(R.id.rvSaved)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        val btnMessages = findViewById<ImageButton>(R.id.btnMessages)

        val savedProperties = listOf(
            Property(
                name = "Casa de playa, La Paz",
                dates = "jun 10-12 · 2 noches",
                price = "$1820 / noche",
                rating = "4.9",
                imageRes = android.R.drawable.ic_menu_gallery
            ),
            Property(
                name = "Casa, La Paz",
                dates = "may 25-28 · 3 noches",
                price = "$1900 / noche",
                rating = "4.5",
                imageRes = android.R.drawable.ic_menu_gallery
            )
        )

        rvSaved.layoutManager = LinearLayoutManager(this)
        rvSaved.adapter = SavedAdapter(savedProperties)

        btnHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

        btnMessages.setOnClickListener {
            startActivity(Intent(this, MessagesActivity::class.java))
        }
    }
}