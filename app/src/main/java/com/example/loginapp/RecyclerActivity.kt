package com.example.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapp.adapter.ItemAdapter
import com.example.loginapp.model.Item

class
RecyclerActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dataList = listOf(
            Item(
                R.drawable.gambar1,
                "Manchester United",
                "Manchester United adalah salah satu klub paling legendaris di dunia sepak bola, berbasis di Old Trafford, Inggris. Klub ini memiliki sejarah panjang dan kaya akan prestasi, termasuk 20 gelar Liga Inggris dan 3 trofi Liga Champions UEFA. Dikenal dengan julukan 'The Red Devils', klub ini telah melahirkan banyak pemain legendaris seperti Ryan Giggs, Paul Scholes, hingga Cristiano Ronaldo."
            ),
            Item(
                R.drawable.gambar2,
                "Real Madrid",
                "Real Madrid merupakan klub sepak bola profesional yang berbasis di Madrid, Spanyol. Dikenal sebagai 'Los Blancos', mereka adalah klub tersukses dalam sejarah Liga Champions UEFA dengan koleksi 14 gelar. Real Madrid memiliki basis penggemar global dan telah menjadi rumah bagi pemain bintang dunia seperti Zinedine Zidane, Cristiano Ronaldo, dan Karim Benzema."
            ),
            Item(
                R.drawable.gambar3,
                "Barcelona",
                "FC Barcelona adalah klub sepak bola dari Catalonia, Spanyol, yang terkenal dengan gaya bermain menyerang dan filosofi tiki-taka. Bermarkas di Camp Nou, Barca telah memenangkan banyak gelar domestik dan Eropa, serta dikenal sebagai klub yang membesarkan Lionel Messi. Semboyan mereka, 'Més que un club' (lebih dari sekadar klub), mencerminkan identitas kuat klub dengan komunitasnya."
            ),
            Item(
                R.drawable.gambar4,
                "Bayern Munich",
                "Bayern Munich adalah klub tersukses di Jerman, dengan markas di Allianz Arena, Munich. Klub ini mendominasi Bundesliga dengan puluhan gelar dan juga menjadi kekuatan utama di Eropa, termasuk 6 gelar Liga Champions. Bayern dikenal karena sistem pengelolaan yang stabil, akademi muda yang produktif, dan gaya bermain kolektif yang disiplin."
            ),
            Item(
                R.drawable.gambar5,
                "Paris Saint-Germain",
                "Paris Saint-Germain (PSG) adalah klub papan atas dari Prancis yang berbasis di Paris. Dalam satu dekade terakhir, PSG menjadi kekuatan besar di Eropa berkat investasi besar yang membawa pemain bintang seperti Neymar, Mbappé, dan Messi. Mereka mendominasi Ligue 1 dan terus berambisi meraih gelar Liga Champions pertama mereka."
            ),
            Item(
                R.drawable.gambar6,
                "Juventus",
                "Juventus FC adalah klub sepak bola paling sukses di Italia dengan sejarah panjang di Serie A. Bermarkas di Turin, Juve dikenal dengan pertahanan solid dan slogan 'Fino Alla Fine' (sampai akhir). Klub ini telah melahirkan legenda seperti Alessandro Del Piero, Gianluigi Buffon, dan baru-baru ini diperkuat oleh Cristiano Ronaldo."
            ),
            Item(
                R.drawable.gambar7,
                "Chelsea",
                "Chelsea FC adalah klub yang berbasis di London, Inggris, dan telah menjadi kekuatan besar di Eropa sejak awal 2000-an. Klub ini dikenal dengan permainan agresif dan berhasil meraih gelar Liga Champions pada tahun 2012 dan 2021. Stamford Bridge menjadi rumah bagi para pemain bintang dan manajer elite yang silih berganti membawa prestasi."
            ),
            Item(
                R.drawable.gambar8,
                "Liverpool",
                "Liverpool FC adalah klub bersejarah yang bermarkas di Anfield, Inggris. Dikenal dengan atmosfer stadion yang luar biasa dan nyanyian 'You'll Never Walk Alone', Liverpool telah menorehkan banyak prestasi, termasuk 6 gelar Liga Champions dan 19 gelar Liga Inggris. Di bawah manajer Jürgen Klopp, klub ini kembali menjadi kekuatan dominan dalam sepak bola dunia."
            )
        )


        adapter = ItemAdapter(dataList)
        recyclerView.adapter = adapter
    }
}
