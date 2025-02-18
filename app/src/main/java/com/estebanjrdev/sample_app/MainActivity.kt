package com.estebanjrdev.sample_app

import ComposeRichForm
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.composerichforms.core.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val formState = remember { FormState() }

                val fields = listOf(
                    FormField.TextField("email", "Correo Electrónico", "ejemplo@correo.com", listOf(Validators.Email, Validators.Required)),
                    FormField.PasswordField("password", "Contraseña", listOf(Validators.Required, Validators.MinLength(6))),
                    FormField.Checkbox("terms", "Acepto los términos y condiciones", listOf(Validators.Required))
                )

                ComposeRichForm(
                    state = formState,
                    fields = fields
                ) { formData ->
                    println("Datos enviados: $formData")
                }
            }
        }
    }
}
