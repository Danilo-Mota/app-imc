package com.example.appimc

import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ResultadoActivity : AppCompatActivity() {
    private val usuario = Imc()
    private lateinit var situacaoText: TextView
    private lateinit var resultadoText: TextView
    private lateinit var seta: ImageView
    var setaUltimaPos: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        onClick()
    }

    private fun onClick() {
        val btnCalc: MaterialButton = findViewById(R.id.calc_button)

        situacaoText = findViewById(R.id.situacao_textView)
        seta = findViewById(R.id.arrow_pointer)

        btnCalc.setOnClickListener {
            val peso: String = findViewById<EditText>(R.id.peso_editText).text.toString()
            val altura: String = findViewById<EditText>(R.id.altura_editText).text.toString()

            if (peso.isNotEmpty() || altura.isNotEmpty()) { // se os campos não estiverem vazios
                usuario.peso = peso.toDouble() // atribui o valor do peso
                usuario.altura = altura.toDouble() // atribui o valor da altura
                usuario.calcularImc() // calcula o imc

                resultadoText = findViewById(R.id.result)


                resultadoText.text = usuario.imc.toString() // exibe o resultado

                if (usuario.altura > 4) {
                    situacaoText.text = "UMA GIRAFA?"
                } else if (usuario.peso > 720) {
                    situacaoText.text = "UMA VACA?"
                } else {
                    var toDegrees: Float // variável para o ângulo de rotação

                    when (usuario.imc) { // when é um switch case
                        in 0.0..18.4 -> { // in é um intervalo
                            toDegrees = -86f
                            situacaoText.text = "ABAIXO DO PESO"
                        }
                        in 18.5..24.9 -> {
                            toDegrees = -50f
                            situacaoText.text = "NORMAL"
                        }
                        in 25.0..29.9 -> {
                            toDegrees = -5f
                            situacaoText.text = "SOBREPESO"
                        }
                        in 30.0..39.9 -> {
                            toDegrees = 30f
                            situacaoText.text = "OBESIDADE"
                        }
                        else -> {
                            toDegrees = 70f
                            situacaoText.text = "OBESIDADE GRAVE"
                        }
                    }

                    // rotação do ângulo
                    val rotation = RotateAnimation(
                        setaUltimaPos,
                        toDegrees,
                        RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,
                        RotateAnimation.RELATIVE_TO_SELF,
                        1f
                    )
                    rotation.duration = 1400 // duração da rotação
                    rotation.interpolator = AccelerateDecelerateInterpolator() // interpolador
                    rotation.isFillEnabled = true // preenchimento
                    rotation.fillAfter = true // preenchimento

                    seta.startAnimation(rotation) // inicia a rotação

                    setaUltimaPos = toDegrees // atualiza a posição da seta
                }

            }
        }
    }
}