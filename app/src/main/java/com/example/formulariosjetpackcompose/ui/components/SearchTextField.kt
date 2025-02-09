package com.example.formulariosjetpackcompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Composable function to create a search text field
@Composable
fun SearchTextField(
    searchText: String, // The current text in the search field
    onSearchChange: (String) -> Unit // Callback function to handle text changes
) {
    // Outlined text field with a search icon, label, and placeholder
    OutlinedTextField(
        value = searchText, // The current value of the text field
        onValueChange = { newValue ->
            onSearchChange(newValue) // Update the text when it changes
        },
        modifier = Modifier
            .padding(16.dp) // Add padding around the text field
            .fillMaxWidth(), // Make the text field fill the width of its parent
        shape = RoundedCornerShape(percent = 100), // Rounded corners for the text field
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Icone") // Search icon
        },
        label = {
            Text(text = "Produto") // Label for the text field
        },
        placeholder = {
            Text(text = "O que você procura ?") // Placeholder text
        }
    )
}