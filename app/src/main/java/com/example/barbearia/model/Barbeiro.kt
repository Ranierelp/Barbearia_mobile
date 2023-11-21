package com.example.barbearia.model

data class Barbeiro(
    val id: String,
    val nome: String,
    val description: String = "",
    val isFavorite: Boolean = false,
    val isFeatured: Boolean = false,
    val urlImage: String = ""
)
