package com.example.appimc

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import java.text.DecimalFormat

class ResultadoActivity : AppCompatActivity() {
    private val calcular = Calcular()
    private lateinit var peso: String
    private lateinit var altura: String
    private lateinit var situacaoText: TextView
    private lateinit var resultadoText: TextView
    private lateinit var seta: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        onClick()
    }

    private fun onClick() {
        val btnCalc: MaterialButton = findViewById(R.id.calc_button)
        val rodarObeso = AnimationUtils.loadAnimation(this, R.anim.rodar_obeso)
        val rodarAcima = AnimationUtils.loadAnimation(this, R.anim.rodar_acima)
        val rodarNormal = AnimationUtils.loadAnimation(this, R.anim.rodar_normal)
        val rodarAbaixo = AnimationUtils.loadAnimation(this, R.anim.rodar_abaixo)
        situacaoText = findViewById(R.id.situacao_textView)
        seta = findViewById(R.id.icon_levels)
        btnCalc.setOnClickListener {
            peso = findViewById<EditText>(R.id.peso_editText).text.toString()
            altura = findViewById<EditText>(R.id.altura_editText).text.toString()
            resultadoText = findViewById(R.id.result)

            if (peso.isBlank() || altura.isBlank()) {
                resultadoText.text = "..."
            } else {
                calcular.set(peso.toFloat(), altura.toFloat())
                val dec = DecimalFormat("0.0")
                val resultadoFormat = dec.format(calcular.get())
                resultadoText.text = resultadoFormat.toString()

                if (altura.toFloat() > 4) {
                    situacaoText.text = "UMA GIRAFA?"
                } else if (peso.toFloat() > 720) {
                    situacaoText.text = "UMA VACA?"
                } else if (calcular.get() <= 18.5) {
                    seta.animation = rodarAbaixo
                    situacaoText.text = "ABAIXO DO PESO"
                } else if (calcular.get() <= 25.0) {
                    seta.animation = rodarNormal
                    situacaoText.text = "SAUDÁVEL"
                } else if (calcular.get() <= 30.0) {
                    seta.animation = rodarAcima
                    situacaoText.text = "ACIMA DO PESO"
                } else {
                    seta.animation = rodarObeso
                    situacaoText.text = "OBESO"
                }
            }
        }
    }
}