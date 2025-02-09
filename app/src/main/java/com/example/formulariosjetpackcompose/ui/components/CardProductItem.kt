package com.example.formulariosjetpackcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.formulariosjetpackcompose.R
import com.example.formulariosjetpackcompose.extensions.toBrazilianCurrency
import com.example.formulariosjetpackcompose.model.Product
import com.example.formulariosjetpackcompose.ui.theme.Indigo400Light

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp
) {
    // Cria um cartão com elevação e largura máxima
    Card(
        modifier
            .fillMaxWidth()
            .heightIn(150.dp), // Define a altura mínima do cartão
        elevation = CardDefaults.cardElevation(elevation) // Define a elevação do cartão
    ) {
        Column {
            // Exibe a imagem do produto
            AsyncImage(
                model = product.image,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp), // Define a altura da imagem
                placeholder = painterResource(id = R.drawable.placeholder), // Imagem de placeholder
                contentScale = ContentScale.Crop // Escala a imagem para preencher o espaço
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(color = Indigo400Light) // Define a cor de fundo
                    .padding(16.dp) // Adiciona padding interno
            ) {
                // Exibe o nome do produto
                Text(
                    text = product.name
                )
                // Exibe o preço do produto formatado para a moeda brasileira
                Text(
                    text = product.price.toBrazilianCurrency()
                )
            }
            // Se houver descrição, exibe-a
            product.description?.let {
                Text(
                    text = product.description,
                    Modifier.padding(16.dp), // Adiciona padding ao texto da descrição
                )
            }
        }
    }
}

@Preview
@Composable
fun CardProductItemPreview() {
    // Pré-visualização do componente CardProductItem sem descrição
    CardProductItem(
        product = Product(
            name = "Product Name",
            price = 100.0.toBigDecimal(),
            image = "https://www.example.com/image.jpg"
        )
    )
}

@Preview
@Composable
fun CardProductItemPreviewWithDescription() {
    // Pré-visualização do componente CardProductItem com descrição
    CardProductItem(
        product = Product(
            name = "Teste Product with description",
            price = 9.99.toBigDecimal(),
            description = LoremIpsum(50).values.first(), // Descrição de exemplo
        )
    )
}