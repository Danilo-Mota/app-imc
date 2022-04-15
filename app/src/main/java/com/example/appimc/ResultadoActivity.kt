package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView

class ResultadoActivity : AppCompatActivity() {
   private lateinit var seta:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        seta = findViewById(R.id.seta)
        rodar()
    }

    private fun rodar(){
        val rodar = AnimationUtils.loadAnimation(this, R.anim.rodar_teste)
        seta.animation = rodar
    }
}