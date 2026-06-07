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

class PaymentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )

        val etCardName = findViewById<EditText>(R.id.etCardName)
        val etCardNumber = findViewById<EditText>(R.id.etCardNumber)
        val etExpDate = findViewById<EditText>(R.id.etExpDate)
        val etCVV = findViewById<EditText>(R.id.etCVV)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etPostalCode = findViewById<EditText>(R.id.etPostalCode)
        val etExtNumber = findViewById<EditText>(R.id.etExtNumber)
        val etIntNumber = findViewById<EditText>(R.id.etIntNumber)
        val btnAddCard = findViewById<Button>(R.id.btnAddCard)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        val btnSaved = findViewById<ImageButton>(R.id.btnSaved)
        val btnMessages = findViewById<ImageButton>(R.id.btnMessages)

        btnAddCard.setOnClickListener {
            val name = etCardName.text.toString().trim()
            val number = etCardNumber.text.toString().trim()
            val expDate = etExpDate.text.toString().trim()
            val cvv = etCVV.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val postalCode = etPostalCode.text.toString().trim()

            if (name.isEmpty() || number.isEmpty() || expDate.isEmpty() ||
                cvv.isEmpty() || address.isEmpty() || postalCode.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Tarjeta agregada correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnCancel.setOnClickListener {
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