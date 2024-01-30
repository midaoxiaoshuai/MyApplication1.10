package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar

class DialogActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        val imageView :ImageView = findViewById(R.id.image1 )
        val progressBar:ProgressBar = findViewById(R.id.progress1)
        imageView.setOnClickListener {
            imageView.setImageResource(R.drawable.img2)
            if (progressBar.visibility == View.VISIBLE) {
                progressBar.visibility = View.GONE
            } else {
                progressBar.visibility = View.VISIBLE
            }
            progressBar.progress = progressBar.progress + 10
        }
    }
}