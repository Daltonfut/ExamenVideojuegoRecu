package com.example.examenrecuperacionandroid.ui.theme.viewmodel


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.examenrecuperacionandroid.ui.theme.modelo.Juego
import com.google.firebase.firestore.FirebaseFirestore

class JuegoViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    val juegos = mutableStateListOf<Juego>()

    init {
        obtenerJuegos()
    }

    private fun obtenerJuegos() {
        db.collection("Juegos").addSnapshotListener { snapshot, _ ->
            if (snapshot != null) {
                juegos.clear()
                val lista = snapshot.documents.map { doc ->
                    Juego(
                        id = doc.id,
                        nombre = doc.getString("nombre") ?: "",
                        descripcion = doc.getString("descripcion") ?: "",
                        plataforma = doc.getString("plataforma") ?: "",
                        nota = doc.getDouble("nota") ?: 0.0,
                        imagen = doc.getString("imagen") ?: ""
                    )
                }
                juegos.addAll(lista)
            }
        }
    }

    fun agregarJuego(nombre: String, desc: String, plat: String, nota: Double, url: String, onExito: () -> Unit) {
        val juego = hashMapOf(
            "nombre" to nombre,
            "descripcion" to desc,
            "plataforma" to plat,
            "nota" to nota,
            "imagen" to url
        )
        db.collection("Juegos").add(juego).addOnSuccessListener { onExito() }
    }

    fun eliminarJuego(id: String) {
        db.collection("Juegos").document(id).delete()
    }
}