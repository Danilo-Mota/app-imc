package com.example.appimc

class Calcular {
    private var peso: Float = 0F
    private var altura: Float = 0F

    fun set(peso: Float, altura: Float) {
        this.peso = peso
        this.altura = altura
    }

    fun get(): Float {
        return peso / (altura * altura)
    }
}