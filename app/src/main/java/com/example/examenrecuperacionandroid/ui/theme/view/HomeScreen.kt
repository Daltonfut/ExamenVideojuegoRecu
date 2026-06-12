package com.example.examenrecuperacionandroid.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.examenrecuperacionandroid.R
import com.example.examenrecuperacionandroid.ui.theme.modelo.Juego
import com.example.examenrecuperacionandroid.ui.theme.viewmodel.JuegoViewModel

@Composable
fun HomeScreen(onNavigateToNuevo: () -> Unit, onLogout: () -> Unit, vm: JuegoViewModel = viewModel()) {
    Scaffold(
        bottomBar = {
            Button(
                onClick = onNavigateToNuevo,
                modifier = Modifier.fillMaxWidth().padding(16.dp).height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5d7d7c))
            ) {
                Text("Agregar Videojuego", color = Color.White)
            }
        }
    ) { pad ->
        Column(modifier = Modifier.padding(pad).fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Videojuegos", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = onLogout) {
                    Icon(Icons.Default.Delete, contentDescription = "Salir", tint = Color.Gray)
                }
            }

            LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
                items(vm.juegos) { juego ->
                    JuegoItem(juego, onDelete = { vm.eliminarJuego(juego.id) })
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun JuegoItem(juego: Juego, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF2F2F2))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {
                val notaColor = when {
                    juego.nota < 5 -> Color.Red
                    juego.nota < 7 -> Color(0xFFFFA500)
                    else -> Color(0xFF27D21F)
                }
                
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(notaColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = juego.nota.toString(), color = Color.White, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.width(12.dp))
                
                AsyncImage(
                    model = juego.imagen,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = juego.nombre, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            
            val iconRes = when (juego.plataforma) {
                "PS5" -> R.drawable.ps
                "Nintendo Switch" -> R.drawable.nintendo
                "PC" -> R.drawable.windows
                "XBox" -> R.drawable.xbox
                else -> R.drawable.windows
            }
            
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp).padding(vertical = 2.dp)
            )

            Text(text = juego.descripcion, fontSize = 12.sp, color = Color.DarkGray)

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Borrar", modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}