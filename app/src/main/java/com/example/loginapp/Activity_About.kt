package com.example.loginapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class Activity_About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Mendapatkan referensi ke elemen-elemen di layout
        val tvAboutTitle = findViewById<TextView>(R.id.tvAboutTitle)
        val tvAboutDescription = findViewById<TextView>(R.id.tvAboutDescription)
        val tvDeveloper = findViewById<TextView>(R.id.tvDeveloper)
        val tvVersion = findViewById<TextView>(R.id.tvVersion)

        // Menambahkan aksi atau fungsi jika diperlukan
        // Contoh: mengubah teks atau menambahkan interaksi lebih lanjut
        tvAboutTitle.text = "Tentang Aplikasi"
        tvAboutDescription.text = "Aplikasi ini berisi sejarah klub sepak bola dari berbagai belahan dunia. Di dalamnya, Anda dapat menemukan profil pemain, sejarah berdirinya klub, prestasi-prestasi penting, serta perkembangan klub dari masa ke masa."
        tvDeveloper.text = "Dikembangkan oleh:\nNama: Ferly F Batmomolin\nUniversitas:Universitas Sains dan Teknologi Jayapura\nEmail:charlesgdawe@examplepetstore.com"
        tvVersion.text = "Versi Aplikasi: 1.0"
    }
}
