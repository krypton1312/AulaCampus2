package com.example.aplicacionexamen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val butAtras = findViewById<Button>(R.id.buttonAtras)
        val butAdelante = findViewById<Button>(R.id.buttonAdelante)

        val botones = arrayOf(
            findViewById<ImageButton>(R.id.buttonResp1),
            findViewById<ImageButton>(R.id.buttonResp2),
            findViewById<ImageButton>(R.id.buttonResp3),
            findViewById<ImageButton>(R.id.buttonResp4)
        )

        val textPregunta = findViewById<TextView>(R.id.preguntaTexto)
        var contador = 0

        class Pregunta(
            val preguntaTexto: String = "",
            val respuestas: Array<Int>,
            val respuestaCorrecta: Int = 0
        )

        var preguntas = arrayOf(Pregunta(
            "En que foto esta representada el monumento en Ucrania?",
            arrayOf(R.drawable.pregunta1img1,R.drawable.pregunta1img2,R.drawable.pregunta1img3,R.drawable.pregunta1img4),
            0
        ))

        fun cambiarPregunta(preguntas: Array<Pregunta>, contador: Int, botones:Array<ImageButton>){
            if(contador == 0){
                butAtras.isEnabled = false
            }else{
                butAtras.isEnabled = true
            }
            if(contador == 10){
                butAdelante.isEnabled = false
            }else{
                butAdelante.isEnabled = true
            }
            for(i in botones.indices){
                botones[i].setImageResource(preguntas[contador].respuestas[i])
            }
        }

        cambiarPregunta(preguntas, contador, botones)
    }

}