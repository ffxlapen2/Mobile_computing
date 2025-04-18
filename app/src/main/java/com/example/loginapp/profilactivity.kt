package com.example.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        supportActionBar?.title = "Profil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Menangani tombol back di action bar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
