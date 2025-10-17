package com.example.aplicacionexamen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
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

        val respuestas = arrayOfNulls<Int>(10)

        val botones = arrayOf(
            findViewById<ImageButton>(R.id.buttonResp1),
            findViewById<ImageButton>(R.id.buttonResp2),
            findViewById<ImageButton>(R.id.buttonResp3),
            findViewById<ImageButton>(R.id.buttonResp4)
        )

        val numeroPregunta = findViewById<TextView>(R.id.textViewTitle)
        val textPregunta = findViewById<TextView>(R.id.preguntaTexto)
        var contador = 0
        var mostrandoResultados = false

        data class Pregunta(
            val preguntaTexto: String,
            val respuestas: Array<Int>,
            val respuestaCorrecta: Int
        )

        val preguntas = arrayOf(
            Pregunta(
                "En qué imagen está representado el monumento en Ucrania?",
                arrayOf(
                    R.drawable.pregunta1img1, R.drawable.pregunta1img2,
                    R.drawable.pregunta1img3, R.drawable.pregunta1img4
                ),
                0
            ),
            Pregunta(
                "En qué imagen aparece la Torre Eiffel?",
                arrayOf(
                    R.drawable.pregunta2img1, R.drawable.pregunta2img2,
                    R.drawable.pregunta2img3, R.drawable.pregunta2img4
                ),
                2
            ),
            Pregunta(
                "Cuál de estas frutas es una piña?",
                arrayOf(
                    R.drawable.pregunta3img1, R.drawable.pregunta3img2,
                    R.drawable.pregunta3img3, R.drawable.pregunta3img4
                ),
                1
            ),
            Pregunta(
                "En qué foto aparece un gato?",
                arrayOf(
                    R.drawable.pregunta4img1, R.drawable.pregunta4img2,
                    R.drawable.pregunta4img3, R.drawable.pregunta4img4
                ),
                2
            ),
            Pregunta(
                "Cuál de estos animales puede volar?",
                arrayOf(
                    R.drawable.pregunta5img1, R.drawable.pregunta5img2,
                    R.drawable.pregunta5img3, R.drawable.pregunta5img4
                ),
                1
            ),
            Pregunta(
                "Cual de esas cryptomonenas NO es un altcoin?",
                arrayOf(
                    R.drawable.pregunta6img1, R.drawable.pregunta6img2,
                    R.drawable.pregunta6img3, R.drawable.pregunta6img4
                ),
                1
            ),
            Pregunta(
                "Que lenguaje de programacion es el mas lento?",
                arrayOf(
                    R.drawable.pregunta7img1, R.drawable.pregunta7img2,
                    R.drawable.pregunta7img3, R.drawable.pregunta7img4
                ),
                2
            ),
            Pregunta(
                "Cuál de las siguientes monedas es considerada la más estable del mundo en los últimos años?",
                arrayOf(
                    R.drawable.pregunta8img1, R.drawable.pregunta8img2,
                    R.drawable.pregunta8img3, R.drawable.pregunta8img4
                ),
                2
            ),
            Pregunta(
                "Cuál de estos animales vive en el océano?",
                arrayOf(
                    R.drawable.pregunta9img1, R.drawable.pregunta9img2,
                    R.drawable.pregunta9img3, R.drawable.pregunta9img4
                ),
                3
            ),
            Pregunta(
                "Cual de los siguentes lenguajes de programacion utilizan para desarrollar applicaciones para IOS?",
                arrayOf(
                    R.drawable.pregunta10img1, R.drawable.pregunta7img2,
                    R.drawable.pregunta7img3, R.drawable.pregunta7img4
                ),
                0
            )
        )


        fun cambiarPregunta(contador: Int) {
            numeroPregunta.text = "Pregunta #${contador + 1}"
            textPregunta.text = preguntas[contador].preguntaTexto
            butAtras.isVisible = contador > 0
            butAdelante.text = if (contador == preguntas.size - 1) "Resultados" else "Adelante"

            for (i in botones.indices) {
                botones[i].setImageResource(preguntas[contador].respuestas[i])
                // Сбрасываем foreground
                botones[i].foreground = ContextCompat.getDrawable(this, R.drawable.answer_bg)
            }

            respuestas[contador]?.let { selected ->
                botones[selected].foreground =
                    ContextCompat.getDrawable(this, R.drawable.answer_bg_selected)
            }
        }

        for (i in botones.indices) {
            botones[i].setOnClickListener {
                for (b in botones) {
                    b.foreground = ContextCompat.getDrawable(this, R.drawable.answer_bg)
                }
                it.foreground = ContextCompat.getDrawable(this, R.drawable.answer_bg_selected)
                respuestas[contador] = i
            }
        }

        fun showOrHideElements(action: Boolean) {
            for (i in botones) {
                i.isVisible = action
            }
        }

        fun corregir(): Int {
            var correctas = 0
            for (i in respuestas.indices) {
                val seleccion = respuestas[i]
                val correcta = preguntas[i].respuestaCorrecta
                if (seleccion != null && seleccion == correcta) {
                    correctas++
                }
            }
            return correctas
        }

        butAdelante.setOnClickListener {
            if (contador < preguntas.size - 1) {
                contador++
                cambiarPregunta(contador)
            } else {
                mostrandoResultados = true
                showOrHideElements(false)
                val resultado = corregir()
                numeroPregunta.text = "Resultados:"
                textPregunta.text = "Has acertado $resultado de ${preguntas.size} preguntas."
                butAdelante.isVisible = false
                butAtras.text = "Volver"
            }
        }

        butAtras.setOnClickListener {
            if (mostrandoResultados) {
                mostrandoResultados = false
                butAdelante.isVisible = true
                butAdelante.text = "Adelante"
                contador = preguntas.size - 1
                showOrHideElements(true)
                cambiarPregunta(contador)
            } else if (contador > 0) {
                contador--
                cambiarPregunta(contador)
            }
        }

        cambiarPregunta(contador)
    }
}
