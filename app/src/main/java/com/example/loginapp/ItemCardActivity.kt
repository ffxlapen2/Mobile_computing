package com.example.loginapp

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_card)

        tts = TextToSpeech(this, this)

        val item = intent.getParcelableExtra<Item>("item")

        val img: ImageView = findViewById(R.id.detailImage)
        title = findViewById(R.id.detailTitle)
        desc = findViewById(R.id.detailDesc)
        val buttonSpeak: Button = findViewById(R.id.buttonSpeak)

        item?.let {
            img.setImageResource(it.imageSource)
            title.text = it.imageTitle
            desc.text = it.imageDesc
        }

        buttonSpeak.setOnClickListener {
            val textToRead = "${title.text}. ${desc.text}"
            speak(textToRead)
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
        super.onDestroy()
    }
}
