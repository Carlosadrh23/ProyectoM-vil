package com.example.proyectoairbnbmovil

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val tvPropertyName = findViewById<TextView>(R.id.tvPropertyName)
        val tvRating = findViewById<TextView>(R.id.tvRating)
        val tvReviews = findViewById<TextView>(R.id.tvReviews)
        val tvHost = findViewById<TextView>(R.id.tvHost)
        val tvBeds = findViewById<TextView>(R.id.tvBeds)
        val tvBaths = findViewById<TextView>(R.id.tvBaths)
        val tvGuests = findViewById<TextView>(R.id.tvGuests)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val tvPrice = findViewById<TextView>(R.id.tvPrice)

        val name = intent.getStringExtra("name") ?: "Propiedad"
        val rating = intent.getStringExtra("rating") ?: "0.0"
        val reviews = intent.getStringExtra("reviews") ?: "0"
        val description = intent.getStringExtra("description") ?: ""
        val host = intent.getStringExtra("host") ?: "Anfitrión"
        val price = intent.getStringExtra("price") ?: ""

        tvPropertyName.text = name
        tvRating.text = rating
        tvReviews.text = " · $reviews reseñas"
        tvHost.text = "Anfitrión · $host"
        tvDescription.text = description
        tvPrice.text = price

        btnBack.setOnClickListener {
            finish()
        }
    }
}