package com.example.calculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var total: TextView
    private lateinit var lastmoveText: TextView
    private lateinit var buttons: List<Button>
    fun evaluateExpression(expr: String): Double {
        return ExpressionBuilder(expr).build().evaluate()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        total = findViewById(R.id.total)
        lastmoveText = findViewById(R.id.lastmoveText)

        buttons = listOf(
            findViewById(R.id.buttonClearAll),
            findViewById(R.id.buttonClear),
            findViewById(R.id.buttonPorc),
            findViewById(R.id.buttonDivide),

            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
            findViewById(R.id.buttonMulti),

            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.buttonMinus),

            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.buttonPlus),

            findViewById(R.id.buttonSqrt),
            findViewById(R.id.button0),
            findViewById(R.id.buttonPoint),
            findViewById(R.id.buttonTotal)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                when (button.id) {
                    R.id.buttonClearAll -> {
                        total.text = ""
                        lastmoveText.text = ""
                    }
                    R.id.buttonClear -> {
                        val current = total.text.toString()
                        if (current.isNotEmpty()) {
                            total.text = current.dropLast(1)
                        }
                    }
                    R.id.buttonTotal -> {
                        try {
                            val expression = total.text.toString()
                            val result = evaluateExpression(expression)
                            total.text = result.toString()
                            lastmoveText.text = expression
                        } catch (e: Exception) {
                            total.text = "Error"
                        }
                    }
                    R.id.buttonSqrt -> {
                        val current = total.text.toString()
                        if (current.isNotEmpty()) {
                            try {
                                val value = current.toDouble()
                                val result = value * value
                                total.text = result.toString()
                                lastmoveText.text = "$current²"
                            } catch (e: Exception) {
                                total.text = "Error"
                            }
                        }
                    }
                    R.id.buttonPorc -> {
                        val current = total.text.toString()
                        if (current.isNotEmpty()) {
                            try {
                                val value = current.toDouble()
                                val result = value / 100
                                total.text = result.toString()
                                lastmoveText.text = "$current%"
                            } catch (e: Exception) {
                                total.text = "Error"
                            }
                        }
                    }

                    else -> {
                        total.text = total.text.toString() + button.text
                    }
                }

            }

        }
    }
}