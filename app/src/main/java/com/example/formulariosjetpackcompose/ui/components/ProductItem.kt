package com.example.formulariosjetpackcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.formulariosjetpackcompose.R
import com.example.formulariosjetpackcompose.extensions.toBrazilianCurrency
import com.example.formulariosjetpackcompose.model.Product
import java.math.BigDecimal

@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    // Surface with rounded corners and shadow elevation
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp), shadowElevation = 8.dp
    ) {
        // Column to arrange elements vertically
        Column(
            modifier = Modifier
                .heightIn(250.dp, 300.dp) // Set minimum and maximum height
                .width(200.dp) // Set width
        ) {
            val imageSize = 100.dp
            // Box to contain the image with gradient background
            Box(
                modifier = Modifier
                    .height(imageSize) // Set box height
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary, // Primary theme color
                                MaterialTheme.colorScheme.secondary // Secondary theme color
                            )
                        )
                    )
                    .fillMaxWidth() // Fill parent's width
            ) {
                // Asynchronous image to load product image
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    modifier = Modifier
                        .size(imageSize) // Set image size
                        .offset(y = imageSize / 2) // Vertically offset the image
                        .clip(shape = CircleShape) // Clip image to circle shape
                        .align(Alignment.BottomCenter), // Align image to bottom center
                    contentScale = androidx.compose.ui.layout.ContentScale.Crop // Crop image to fill bounds
                )
            }
            // Spacer to add space between elements
            Spacer(modifier = Modifier.height(imageSize / 2))
            // Column to arrange text elements vertically
            Column(modifier = Modifier.padding(8.dp)) {
                // Text to display product name
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis // Ellipsis for overflow text
                )
                // Text to display product price in Brazilian currency format
                Text(
                    text = product.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
private fun ProductItemPreview() {
    // Preview of the ProductItem composable
    Surface {
        ProductItem(
            Product(
                name = LoremIpsum(50).values.first(), // Example product name
                price = BigDecimal("14.99") // Example product price
            )
        )
    }
}