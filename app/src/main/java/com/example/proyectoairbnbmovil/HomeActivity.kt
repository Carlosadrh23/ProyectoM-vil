package com.example.proyectoairbnbmovil

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val rvProperties = findViewById<RecyclerView>(R.id.rvProperties)

        val properties = listOf(
            Property(
                name = "Casa de playa, La paz",
                dates = "2 noches · jun 10-12",
                price = "$1820 / noche",
                rating = "4.9",
                imageRes = android.R.drawable.ic_menu_gallery
            ),
            Property(
                name = "Casa, La paz",
                dates = "3 noches · may 25-28",
                price = "$1900 / noche",
                rating = "4.5",
                imageRes = android.R.drawable.ic_menu_gallery
            ),
            Property(
                name = "Departamento, La paz",
                dates = "1 noche · jul 5-6",
                price = "$950 / noche",
                rating = "4.7",
                imageRes = android.R.drawable.ic_menu_gallery
            )
        )

        rvProperties.layoutManager = LinearLayoutManager(this)
        rvProperties.adapter = PropertyAdapter(properties)
    }
}