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
                "🇮🇩 Manchester United didirikan pada 1878 dengan nama Newton Heath. Klub ini hampir bangkrut pada awal abad ke-20 sebelum berubah nama menjadi Manchester United pada 1902. Tragedi Munich 1958 yang merenggut nyawa banyak pemain menjadi titik terendah klub. Namun, di bawah Sir Matt Busby, klub bangkit dan memenangkan Liga Champions pertama mereka pada 1968. Era Sir Alex Ferguson (1986–2013) membawa kejayaan luar biasa, termasuk treble 1999. Setelah pensiunnya Ferguson, klub mengalami pasang surut, namun tetap menjadi salah satu klub paling terkenal di dunia.\n\n" +
                        "🇬🇧 Manchester United was founded in 1878 as Newton Heath. The club nearly went bankrupt in the early 20th century before becoming Manchester United in 1902. The Munich Air Disaster in 1958 marked a tragic low point. Under Sir Matt Busby, they rebuilt and won their first European Cup in 1968. The Sir Alex Ferguson era (1986–2013) brought immense success, including the 1999 treble. Post-Ferguson, the club has seen ups and downs but remains one of the world’s most iconic teams."
            ),
            Item(
                R.drawable.gambar2,
                "Manchester City",
                "🇮🇩 Didirikan tahun 1880 sebagai St. Mark's, klub ini berganti nama menjadi Manchester City pada 1894. Mereka meraih sukses awal di awal abad ke-20 namun mengalami masa sulit dan degradasi beberapa kali. Titik balik terjadi pada 2008 saat diakuisisi oleh Sheikh Mansour. Dengan dana besar dan manajemen modern, City berubah menjadi kekuatan dominan di Inggris, memenangkan banyak gelar domestik, termasuk treble bersejarah pada musim 2022–23 di bawah Pep Guardiola.\n\n" +
                        "🇬🇧 Founded in 1880 as St. Mark’s, the club became Manchester City in 1894. After early successes, the club struggled for decades, experiencing multiple relegations. A turning point came in 2008 when Sheikh Mansour bought the club. With massive investment and modern management, City became a dominant force in English football, winning numerous domestic titles, including a historic treble in 2022–23 under Pep Guardiola."
            ),
            Item(
                R.drawable.gambar3,
                "Bayern Munich",
                "🇮🇩 Bayern Munich didirikan pada 1900 dan berkembang menjadi kekuatan besar di sepak bola Jerman dan Eropa. Mereka mulai mendominasi Bundesliga sejak 1970-an dengan generasi emas Franz Beckenbauer. Bayern meraih treble pada 2012–13 dan mengulangi dominasi di musim 2019–20 dengan rekor luar biasa. Dikenal karena manajemen stabil dan regenerasi pemain, Bayern adalah simbol kesuksesan Jerman.\n\n" +
                        "🇬🇧 Bayern Munich was founded in 1900 and rose to become a major power in German and European football. They began dominating the Bundesliga in the 1970s, led by the legendary Franz Beckenbauer. Bayern won a treble in 2012–13 and again showed dominance in 2019–20 with a historic run. Known for stability and player development, Bayern is a model of German football success."
            ),
            Item(
                R.drawable.gambar4,
                "Borussia Dortmund",
                "🇮🇩 Borussia Dortmund berdiri tahun 1909 dan mencapai puncak di tahun 1997 dengan menjuarai Liga Champions. Setelah itu, klub sempat terpuruk dan hampir bangkrut pada awal 2000-an. Namun, di bawah pelatih Jürgen Klopp, mereka bangkit kembali dan meraih dua gelar Bundesliga pada 2010–11 dan 2011–12. Klub ini dikenal karena dukungan suporter fanatik dan pengembangan pemain muda.\n\n" +
                        "🇬🇧 Borussia Dortmund was founded in 1909 and reached its peak in 1997 by winning the Champions League. The club nearly went bankrupt in the early 2000s. Under coach Jürgen Klopp, Dortmund made a strong comeback, winning the Bundesliga in 2010–11 and 2011–12. The club is famous for its passionate fans and youth development system."
            ),
            Item(
                R.drawable.gambar5,
                "Juventus",
                "🇮🇩 Juventus FC berdiri pada 1897 dan merupakan klub paling sukses di Italia. Mereka meraih dominasi besar di Serie A selama dekade terakhir. Namun, skandal Calciopoli tahun 2006 membuat Juve terdegradasi ke Serie B. Mereka kembali ke Serie A dan mendominasi lagi, memenangkan 9 gelar beruntun dari 2012 hingga 2020. Saat ini, klub dalam proses rekonstruksi setelah beberapa krisis manajerial dan finansial.\n\n" +
                        "🇬🇧 Juventus FC was founded in 1897 and is Italy’s most successful club. After dominating Serie A in recent decades, they were relegated to Serie B in 2006 due to the Calciopoli scandal. They returned and went on to win 9 straight league titles from 2012 to 2020. The club is now undergoing rebuilding after managerial and financial setbacks."
            ),
            Item(
                R.drawable.gambar6,
                "Inter Milan",
                "🇮🇩 Inter Milan didirikan pada 1908 sebagai pemisahan dari AC Milan. Inter adalah satu-satunya klub Italia yang tak pernah terdegradasi dari Serie A. Mereka mencapai puncak saat meraih treble pada 2010 di bawah José Mourinho. Setelah itu mengalami penurunan, namun kembali bangkit dan menjuarai Serie A musim 2020–21 di bawah Antonio Conte.\n\n" +
                        "🇬🇧 Inter Milan was founded in 1908 following a split from AC Milan. Inter is the only Italian club never relegated from Serie A. They peaked with a treble in 2010 under José Mourinho. The club went through a decline but returned to the top by winning Serie A in 2020–21 under Antonio Conte."
            ),
            Item(
                R.drawable.gambar7,
                "Real Madrid",
                "🇮🇩 Didirikan tahun 1902, Real Madrid menjadi simbol kejayaan sepak bola Spanyol dan Eropa. Mereka sukses di era awal dengan banyak gelar domestik dan menjadi klub pertama yang menjuarai lima Liga Champions beruntun (1956–60). Era 'Galácticos' awal 2000-an membawa bintang-bintang seperti Zidane dan Ronaldo. Di era modern, mereka dominan dengan 5 gelar UCL sejak 2014 di bawah Zidane dan Ancelotti.\n\n" +
                        "🇬🇧 Founded in 1902, Real Madrid became a symbol of football excellence in Spain and Europe. They won the first five European Cups (1956–60). The early 2000s 'Galácticos' era brought in stars like Zidane and Ronaldo. In modern times, they dominated again, winning 5 UCL titles since 2014 under Zidane and Ancelotti."
            ),
            Item(
                R.drawable.gambar8,
                "FC Barcelona",
                "🇮🇩 FC Barcelona didirikan pada 1899 dan menjadi simbol perjuangan budaya Catalonia. Mereka terkenal dengan filosofi sepak bola menyerang dan pengembangan pemain muda lewat La Masia. Di bawah Guardiola (2008–2012), Barca mencetak era emas dengan gaya 'tiki-taka' dan Lionel Messi sebagai ikon. Meski sempat menurun karena krisis finansial, mereka perlahan bangkit kembali.\n\n" +
                        "🇬🇧 FC Barcelona was founded in 1899 and became a symbol of Catalan cultural identity. Known for attacking football and youth development through La Masia, they enjoyed a golden era under Guardiola (2008–2012) with 'tiki-taka' style and Messi as the icon. Though affected by financial crises, the club is slowly rebuilding its strength."
            )
        )






        adapter = ItemAdapter(dataList)
        recyclerView.adapter = adapter
    }
}
