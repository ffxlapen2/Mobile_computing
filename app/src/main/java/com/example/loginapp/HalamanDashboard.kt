package com.example.loginapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityHalamanDashboardBinding

class HalamanDashboard : AppCompatActivity() {
    private lateinit var binding: ActivityHalamanDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengecek apakah WhatsApp terinstal
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

        // Tombol membuka WhatsApp
        binding.btnbukabrowser.setOnClickListener {
            val intent = packageManager.getLaunchIntentForPackage("com.whatsapp")
            if (intent != null) {
                startActivity(intent)
                Toast.makeText(this, "WhatsApp terbuka!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "WhatsApp tidak ditemukan! Mengarahkan ke Play Store...", Toast.LENGTH_LONG).show()
                val playStoreIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
                )
                startActivity(playStoreIntent)
            }
        }

        // Tombol menuju RecyclerActivity
        binding.btnTambahan.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }
    }

    // Menampilkan menu di pojok kanan atas
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Menangani klik pada menu item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile -> {
                // Pindah ke halaman profil
                startActivity(Intent(this, ProfilActivity::class.java))
                true
            }

            R.id.logout -> {
                // Kembali ke halaman login
                startActivity(Intent(this, MainActivity::class.java))
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
