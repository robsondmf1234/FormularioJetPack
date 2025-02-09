package com.example.formulariosjetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formulariosjetpackcompose.model.Product
import com.example.formulariosjetpackcompose.sampledata.sampleProducts
import com.example.formulariosjetpackcompose.sampledata.sampleSections
import com.example.formulariosjetpackcompose.ui.components.CardProductItem
import com.example.formulariosjetpackcompose.ui.components.ProductsSection
import com.example.formulariosjetpackcompose.ui.components.SearchTextField
import com.example.formulariosjetpackcompose.ui.theme.AluveryLazyLayoutTheme

// Composable function to display the home screen
@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>, // Map of product sections with titles
    searchText: String = "", // Initial search text
) {
    Column {
        // State to hold the current search text
        var text by remember {
            mutableStateOf(searchText)
        }
        // Search text field to input search queries
        SearchTextField(searchText = text, onSearchChange = {
            text = it
        })

        // List of products filtered by the search text
        val searchedProducts = remember(text) {
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(text, ignoreCase = true) ||
                            product.description?.contains(text, ignoreCase = true) ?: false
                }
            } else {
                emptyList()
            }
        }

        // LazyColumn to display the product sections or search results
        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp) // Adds vertical padding
        ) {
            if (text.isBlank()) {
                // Display product sections if search text is blank
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) { products ->
                    CardProductItem(
                        product = products,
                        Modifier.padding(horizontal = 16.dp),
                    )
                }
            }
        }
    }
}

// Preview function to display the HomeScreen composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    AluveryLazyLayoutTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

// Preview function to display the HomeScreen composable with search text
@Preview
@Composable
fun HomePreviewWithSearchText() {
    AluveryLazyLayoutTheme {
        Surface {
            HomeScreen(sampleSections, searchText = "a")
        }
    }
}