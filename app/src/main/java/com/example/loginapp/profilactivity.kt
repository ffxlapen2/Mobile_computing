package com.example.loginapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        supportActionBar?.title = "Profil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Instagram dan WhatsApp
        val igTextView = findViewById<TextView>(R.id.profile_instagram)
        val waTextView = findViewById<TextView>(R.id.profile_whatsapp)

        igTextView.setOnClickListener {
            val igIntent = Intent(Intent.ACTION_VIEW)
            igIntent.data = Uri.parse("https://instagram.com/ferlyyyyyyyyyy") // Ganti sesuai username IG
            startActivity(igIntent)
        }

        waTextView.setOnClickListener {
            val waIntent = Intent(Intent.ACTION_VIEW)
            waIntent.data = Uri.parse("https://wa.me/081248471001") // Ganti dengan nomor WhatsApp
            startActivity(waIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
