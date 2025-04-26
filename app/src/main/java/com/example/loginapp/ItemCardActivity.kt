package com.example.loginapp

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.model.Item
import java.util.*

class ItemCardActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech
    private lateinit var title: TextView
    private lateinit var desc: TextView
    private var mediaPlayer: MediaPlayer? = null
    private var isPlayingLagu = false
    private var isSpeaking = false

    // Lagu diambil dari Item
    private var songResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_card)

        tts = TextToSpeech(this, this)

        val item = intent.getParcelableExtra<Item>("item")

        val img: ImageView = findViewById(R.id.detailImage)
        title = findViewById(R.id.detailTitle)
        desc = findViewById(R.id.detailDesc)
        val buttonSpeak: Button = findViewById(R.id.buttonSpeak)
        val buttonLagu: Button = findViewById(R.id.btnLagu)

        item?.let {
            img.setImageResource(it.imageSource)
            title.text = it.imageTitle
            desc.text = it.imageDesc
            songResId = it.songResId // Dapatkan ID lagu dari Item
        }

        buttonSpeak.setOnClickListener {
            if (isSpeaking) {
                // Pause TTS
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.stop()
                }
                buttonSpeak.text = "▶️ Lanjutkan Baca"
                isSpeaking = false
            } else {
                // Mulai Baca
                val textToRead = "${title.text}. ${desc.text}"
                speak(textToRead)
                buttonSpeak.text = "⏸️ Pause Baca"
                isSpeaking = true
            }
        }

        buttonLagu.setOnClickListener {
            if (mediaPlayer == null) {
                if (songResId != 0) {
                    mediaPlayer = MediaPlayer.create(this, songResId)
                    mediaPlayer?.isLooping = true
                }
            }

            if (isPlayingLagu) {
                mediaPlayer?.pause()
                buttonLagu.text = "▶️ Lanjutkan Lagu"
                isPlayingLagu = false
            } else {
                mediaPlayer?.start()
                buttonLagu.text = "⏸️ Pause Lagu"
                isPlayingLagu = true
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale("id", "ID")
        }
    }

    private fun speak(text: String) {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onDestroy() {
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}
