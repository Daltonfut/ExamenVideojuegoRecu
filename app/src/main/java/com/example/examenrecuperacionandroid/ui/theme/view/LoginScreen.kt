package com.example.examenrecuperacionandroid.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examenrecuperacionandroid.R

@Composable
fun LoginScreen() {
    var email by rememberSaveable() {
        mutableStateOf("")
    }
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    var mostrarPassword by rememberSaveable() {
        mutableStateOf(false)
    }
    var esIncorrecta by rememberSaveable() {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
        )
        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value = email,
            onValueChange = {
                email=it
            },
            label ={
                Text("Email")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value= password,
            onValueChange = {
                password=it
            },
            label = {
                Text("Contraseña")
            },
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {

            },
           
        ) {
            Text("Login")
        }
        if (esIncorrecta){
            AlertDialog(
                onDismissRequest = {
                    esIncorrecta=false
                },
                confirmButton = {
                    Button(
                        onClick = {
                            esIncorrecta=false
                        }
                    ) {
                        Text("Aceptar")
                    }
                },
                title = {
                    Text("Login")
                },
                text = {
                    Text("Usuario o contraseña incorrectos")
                }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewLog(){
    LoginScreen()
}