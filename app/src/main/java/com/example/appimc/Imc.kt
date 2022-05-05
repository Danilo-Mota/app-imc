package com.example.appimc

import java.math.BigDecimal
import kotlin.math.pow

class Imc {
    // Em kotlin, não é necessário criar os métodos get e set, pois são criados automaticamente pela linguagem Kotlin
    // Caso não queira criar os métodos get e set, basta colocar o modificador de acesso private


    var peso: Double = 0.0
    var altura: Double = 0.0
    var imc: Double = 0.0
        private set // nesse caso, o método set não será criado automaticamente, mas o método get será criado automaticamente

    fun calcularImc() {
        imc = peso / altura.pow(2.0) // Calculo do IMC
        val bd = BigDecimal(imc).setScale(1, BigDecimal.ROUND_HALF_EVEN) // Formatação do IMC
        imc = bd.toDouble() // Inserido o valor formatado no atributo imc
    }
}