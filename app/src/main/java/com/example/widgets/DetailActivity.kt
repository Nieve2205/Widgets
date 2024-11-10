package com.example.widgets

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fruitName = intent.getStringExtra("FRUIT_NAME") ?: "Fruta desconocida"
        setContent {
            FruitDetailScreen(fruitName)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitDetailScreen(fruitName: String) {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Detalles de la Fruta") })
    }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(42.dp))
            FruitInfoCard("Manzana", "Rica en fibra y vitamina C.")
            FruitInfoCard("Banana", "Fuente de potasio y energía rápida.")
            FruitInfoCard("Naranja", "Alta en vitamina C y antioxidantes.")
        }
    }
}

@Composable
fun FruitInfoCard(fruitName: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(fruitName, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
