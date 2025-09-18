package com.example.myapplication

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isVisible = false
    private lateinit var mediaPlayer: MediaPlayer

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomContainer = findViewById<LinearLayout>(R.id.bottomContainer)
        val toggleButton = findViewById<Button>(R.id.toggleButton)

        toggleButton.setOnClickListener {
            if (isVisible) {
                val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
                bottomContainer.startAnimation(slideDown)
                bottomContainer.visibility = View.GONE
                toggleButton.text = "⬆"
            } else {
                bottomContainer.visibility = View.VISIBLE
                val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
                bottomContainer.startAnimation(slideUp)
                toggleButton.text = "⬇"
            }
            isVisible = !isVisible
        }

        val aver1Button = findViewById<Button>(R.id.aver1)
        val aver2Button = findViewById<Button>(R.id.aver2)
        val aver3Button = findViewById<Button>(R.id.aver3)

        val text = findViewById<TextView>(R.id.textView2)
        val image = findViewById<ImageView>(R.id.imageView)

        aver1Button.setOnClickListener{
            text.text = "GRANDEEEE, venga, al siguente buton"
            aver1Button.isEnabled = false;
        }

        var isFirstImage = true

        aver2Button.setOnClickListener {
            if (isFirstImage) {
                image.setImageResource(R.drawable.image2)
            } else {
                image.setImageResource(R.drawable.image1)
            }
            isFirstImage = !isFirstImage
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.oldtown)

        aver3Button.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.seekTo(13_000)
                mediaPlayer.start()

            } else {
                mediaPlayer.pause()
            }
            handler.postDelayed({
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                }
            }, 37_000)
        }
    }
}

