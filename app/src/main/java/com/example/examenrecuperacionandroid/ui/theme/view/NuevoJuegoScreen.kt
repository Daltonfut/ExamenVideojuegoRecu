package com.example.examenrecuperacionandroid.ui.theme.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NuevoJuegoScreen() {
    var nombre by rememberSaveable() {
        mutableStateOf("")
    }
    var descripcion by rememberSaveable() {
        mutableStateOf("")
    }
    var nota by rememberSaveable() {
        mutableStateOf("")
    }
    var url by rememberSaveable() {
        mutableStateOf("")
    }
    var juegoAgregado by rememberSaveable() {
        mutableStateOf(false)
    }
    var cancelar by rememberSaveable() {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nuevo Juego",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = nombre,
            onValueChange = {
                nombre=it
            },
            label = {
                Text("Nombre")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = descripcion,
            onValueChange = {
                descripcion=it
            },
            label = {
                Text("Descripción")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Plataforma: "
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = nota,
            onValueChange = {
                nota=it
            },
            label = {
                Text(
                    text = "Nota"
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value= url,
            onValueChange = {
                url = it
            },
            label = {
                Text(
                    text = "URL imagen"
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick={
                juegoAgregado=true
            }
        ) {
            Text("Agregar Juego")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick={
                cancelar=true
            },
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text("Cancelar")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewNuevoJuego(){
    NuevoJuegoScreen()
}