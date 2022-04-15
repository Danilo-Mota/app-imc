package com.example.appimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        comecar()
    }

    private fun comecar(){
        val comecar = findViewById<MaterialButton>(R.id.button)
        val irParaResultadoActivity = Intent(this, ResultadoActivity::class.java)

        comecar.setOnClickListener {
            startActivity(irParaResultadoActivity)
        }
    }
}