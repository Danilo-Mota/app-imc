package com.example.appimc

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ResultadoActivity : AppCompatActivity() {
    private val calcular = Calcular()
    private lateinit var peso: String
    private lateinit var altura: String
    private lateinit var resultadoText: TextView
    //private lateinit var seta: ImageView = findViewById(R.id.seta)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        onClick()
        // rodar()
    }
    private fun onClick(){
        val btnCalc: MaterialButton = findViewById(R.id.calc_button)
        btnCalc.setOnClickListener {
            peso = findViewById<EditText>(R.id.peso_editText).text.toString()
            altura = findViewById<EditText>(R.id.altura_editText).text.toString()
            resultadoText = findViewById(R.id.result)

            calcular.set(peso.toFloat(), altura.toFloat())
            resultadoText.text = calcular.get().toString()
        }
    }

   /* private fun rodar(){
        //   val rodar = AnimationUtils.loadAnimation(this, R.anim.rodar_teste)
        //   seta.animation = rodar
    }*/
}