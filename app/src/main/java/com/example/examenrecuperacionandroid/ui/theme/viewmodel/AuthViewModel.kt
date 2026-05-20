package com.example.examenrecuperacionandroid.ui.theme.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    fun login(email: String, pss: String, onSuccess: () -> Unit, onError: () -> Unit) {
        if (email.isBlank() || pss.isBlank()) {
            onError()
            return
        }
        auth.signInWithEmailAndPassword(email, pss)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) onSuccess()
                else onError()
            }
    }
}