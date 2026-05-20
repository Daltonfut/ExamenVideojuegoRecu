package com.example.examenrecuperacionandroid.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examenrecuperacionandroid.R
import com.example.examenrecuperacionandroid.ui.theme.viewmodel.AuthViewModel

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, authViewModel: AuthViewModel = viewModel()) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var mostrarPassword by rememberSaveable { mutableStateOf(false) }
    var esIncorrecta by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.height(100.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text("Email")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text("Contraseña")
                    },
            visualTransformation = if (mostrarPassword) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Text(
                    text = if (mostrarPassword) "Ocultar" else "Mostrar",
                    modifier = Modifier.padding(end = 8.dp).clickable { mostrarPassword = !mostrarPassword },
                    color = Color.Gray
                )
            }
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                authViewModel.login(email, password, 
                    onSuccess = { onLoginSuccess() },
                    onError = { esIncorrecta = true }
                )
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27D21F))
        ) {
            Text("Login", color = Color.White)
        }

        if (esIncorrecta) {
            AlertDialog(
                onDismissRequest = { esIncorrecta = false },
                confirmButton = {
                    Button(onClick = { esIncorrecta = false }) {
                        Text("Aceptar")
                    }
                },
                title = { Text("Login") },
                text = { Text("Usuario o contraseña incorrectos") }
            )
        }
    }
}