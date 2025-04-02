package com.example.loginapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginapp.adapter.ItemAdapter
import com.example.loginapp.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.recyclerView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. RecyclerView dan LayoutManager
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 2. Data
        val itemList = listOf(
            Item("Manchester United Football Club", "http://www.manutd.com/", R.drawable.gambar1),
            Item("Manchester City Football Club", "http://www.mancity.com/", R.drawable.gambar2),
            Item("Fußball-Club Bayern München e. V.", "https://fcbayern.com/en", R.drawable.gambar3),
            Item("Ballspielverein Borussia 09 e.V. Dortmund", "https://www.bvb.de/", R.drawable.gambar4),
            Item("Juventus Football Club S.p.A.", "http://www.juventus.com/", R.drawable.gambar5),
            Item("Football Club Internazionale Milano S.p.A.", "http://www.inter.it/", R.drawable.gambar6),
            Item("Real Madrid Club de Fútbol", "http://www.realmadrid.com/", R.drawable.gambar7),
            Item("Futbol Club Barcelona", "http://www.fcbarcelona.com/", R.drawable.gambar8)
        )

        // 3. Adapter
        val adapter = ItemAdapter(itemList)

        // 4. Set Adapter
        binding.recyclerView.adapter = adapter
    }
}