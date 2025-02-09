package com.example.formulariosjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.formulariosjetpackcompose.ui.screens.HomeScreen
import com.example.formulariosjetpackcompose.sampledata.sampleSections
import com.example.formulariosjetpackcompose.ui.theme.AluveryLazyLayoutTheme

// MainActivity é o ponto de entrada da aplicação
class MainActivity : ComponentActivity() {
    // onCreate é chamado quando a atividade é criada pela primeira vez
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent define a visualização do conteúdo para a função composable App
        setContent {
            App()
        }
    }
}

// Função composable que define o tema e exibe a HomeScreen
@Composable
fun App() {
    AluveryLazyLayoutTheme {
        Surface {
            HomeScreen(
                sampleSections // Passa as seções de exemplo para a HomeScreen
            )
        }
    }
}

// Função de preview para exibir a função App no preview do Android Studio
@Preview
@Composable
fun AppPreview() {
    AluveryLazyLayoutTheme {
        Surface {
            App()
        }
    }
}