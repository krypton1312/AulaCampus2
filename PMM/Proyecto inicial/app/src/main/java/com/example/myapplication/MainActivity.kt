package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isVisible = false  // флаг состояния панели

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomContainer = findViewById<LinearLayout>(R.id.bottomContainer)
        val toggleButton = findViewById<Button>(R.id.toggleButton)

        toggleButton.setOnClickListener {
            if (isVisible) {
                // прячем
                val slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
                bottomContainer.startAnimation(slideDown)
                bottomContainer.visibility = View.GONE
                toggleButton.text = "⬆"   // стрелка вверх (свернуть)
            } else {
                // показываем
                bottomContainer.visibility = View.VISIBLE
                val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
                bottomContainer.startAnimation(slideUp)
                toggleButton.text = "⬇"   // стрелка вниз (развернуть)
            }
            isVisible = !isVisible
        }

        val aver1Button = findViewById<Button>(R.id.aver1)
        val aver2Button = findViewById<Button>(R.id.aver2)
        val aver3Button = findViewById<Button>(R.id.aver3)

        val text = findViewById<TextView>(R.id.textView2)

        aver1Button.setOnClickListener{
            text.text = "GRANDEEEE, venga, al siguente buton"
            aver1Button.isEnabled = false;
        }
    }
}

