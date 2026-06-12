package com.example.examenrecuperacionandroid.ui.theme.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examenrecuperacionandroid.ui.theme.viewmodel.JuegoViewModel

@Composable
fun NuevoJuegoScreen(onBack: () -> Unit, vm: JuegoViewModel = viewModel()) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var descripcion by rememberSaveable { mutableStateOf("") }
    var nota by rememberSaveable { mutableStateOf("") }
    var url by rememberSaveable { mutableStateOf("") }
    
    val plataformas = listOf("PC", "Nintendo Switch", "PS5", "XBox")
    var expandido by remember { mutableStateOf(false) }
    var platSeleccionada by remember { mutableStateOf(plataformas[0]) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Nuevo Juego", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = nombre, 
            onValueChange = { nombre = it }, 
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = descripcion, 
            onValueChange = { descripcion = it }, 
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Selector de Plataforma (Menú desplegable de la captura)
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            OutlinedButton(onClick = { expandido = true }) {
                Text("Plataforma: $platSeleccionada")
            }
            DropdownMenu(expanded = expandido, onDismissRequest = { expandido = false }) {
                plataformas.forEach { p ->
                    DropdownMenuItem(
                        text = { Text(p) }, 
                        onClick = {
                            platSeleccionada = p
                            expandido = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nota, 
            onValueChange = { nota = it }, 
            label = { Text("Nota") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = url, 
            onValueChange = { url = it }, 
            label = { Text("URL imagen") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                val notaDouble = nota.toDoubleOrNull() ?: 0.0
                vm.agregarJuego(nombre, descripcion, platSeleccionada, notaDouble, url) {
                    onBack()
                }
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5d7d7c))
        ) {
            Text("Agregar Juego")
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Cancelar")
        }
    }
}