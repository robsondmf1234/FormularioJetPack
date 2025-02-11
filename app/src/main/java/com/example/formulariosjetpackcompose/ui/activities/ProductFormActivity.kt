package com.example.formulariosjetpackcompose.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.formulariosjetpackcompose.ui.theme.AluveryLazyLayoutTheme

//TODO("https://cursos.alura.com.br/course/jetpack-compose-formulario-gerenciamento-estado/task/116677")
class ProductFormActivity : ComponentActivity() {
    // onCreate é chamado quando a atividade é criada pela primeira vez
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent define a visualização do conteúdo para a função composable App
        setContent {
            AluveryLazyLayoutTheme {
                Surface {
                    Text(text = "Formulário de Produto")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductFormPreview() {
    AluveryLazyLayoutTheme {
        Surface {
            Text(text = "Formulário de Produto")
        }
    }
}