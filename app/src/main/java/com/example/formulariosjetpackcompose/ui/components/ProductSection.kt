package com.example.formulariosjetpackcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formulariosjetpackcompose.model.Product
import com.example.formulariosjetpackcompose.sampledata.sampleProducts
import com.example.formulariosjetpackcompose.ui.theme.AluveryLazyLayoutTheme


// Composable function to display a section of products with a title
@Composable
fun ProductsSection(
    title: String,
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        // Display the section title
        Text(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        // Display the products in a horizontally scrollable row
        // LazyRow is a composable that allows displaying items in a horizontal row
        // equivalent to RecyclerView with LinearLayoutManager.HORIZONTAL
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp), // Adds spacing between items in the LazyRow
            contentPadding = PaddingValues(horizontal = 16.dp) // Adds horizontal padding, equivalent to paddingStart and paddingEnd to give left and right margins
        ) {
            // Iterate over the products and display each one using the ProductItem composable function
            items(products) { product ->
                ProductItem(product = product)
            }
        }
    }
}

// Preview function to display the ProductsSection function in the Android Studio preview
@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun ProductsSectionPreview() {
    AluveryLazyLayoutTheme {
        Surface {
            // Display a sample products section with the title "Promoções" and sample products
            ProductsSection(title = "Promoções", products = sampleProducts)
        }
    }
}