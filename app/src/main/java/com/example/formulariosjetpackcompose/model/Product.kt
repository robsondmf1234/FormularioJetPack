package com.example.formulariosjetpackcompose.model

import java.math.BigDecimal

// Classe que representa um produto
data class Product(
    // Nome do produto
    val name: String,
    // Preço do produto
    val price: BigDecimal,
    // URL da imagem do produto (opcional)
    val image: String? = null,
    // Descrição do produto (opcional)
    val description: String? = null
)