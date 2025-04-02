package com.example.loginapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityHalamanDashboardBinding

class HalamanDashboard : AppCompatActivity() {
    private lateinit var binding: ActivityHalamanDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cek apakah WhatsApp terinstal
        val installedApps = packageManager.getInstalledApplications(0)
        var isWhatsAppInstalled = false

        for (app in installedApps) {
            if (app.packageName == "com.whatsapp") {
                isWhatsAppInstalled = true
                break
            }
        }

        if (isWhatsAppInstalled) {
            Toast.makeText(this, "WhatsApp ADA di perangkat!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "WhatsApp TIDAK ditemukan!", Toast.LENGTH_LONG).show()
        }

        // Tombol kembali ke MainActivity
        binding.btnKembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnbukabrowser.setOnClickListener {
            val intent = packageManager.getLaunchIntentForPackage("com.whatsapp")

            if (intent != null) {
                startActivity(intent) // Membuka WhatsApp
                Toast.makeText(this, "WhatsApp terbuka!", Toast.LENGTH_SHORT).show()
            } else {
                // Jika WhatsApp tidak ditemukan, buka Play Store
                Toast.makeText(this, "WhatsApp tidak ditemukan! Mengarahkan ke Play Store...", Toast.LENGTH_LONG).show()
                val playStoreIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
                )
                startActivity(playStoreIntent)
            }
        }

        // Tombol "Tugas 4" ke RecyclerActivity
        binding.btnTambahan.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
    }
}