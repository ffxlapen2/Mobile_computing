package com.example.loginapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.model.Item

class ItemCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_card)

        val item = intent.getParcelableExtra<Item>("item")

        val img: ImageView = findViewById(R.id.detailImage)
        val title: TextView = findViewById(R.id.detailTitle)
        val desc: TextView = findViewById(R.id.detailDesc)

        item?.let {
            img.setImageResource(it.imageSource)
            title.text = it.imageTitle
            desc.text = it.imageDesc
        }
    }
}
