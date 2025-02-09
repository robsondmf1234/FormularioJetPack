package com.example.formulariosjetpackcompose.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

// Função de extensão para a classe BigDecimal que converte o valor para o formato de moeda brasileira
fun BigDecimal.toBrazilianCurrency(): String {
    // Obtém uma instância de NumberFormat para a localidade brasileira e formata o valor
    return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(this)
}