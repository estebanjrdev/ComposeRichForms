package com.composerichforms.extensions

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import com.composerichforms.core.*

/**
 * Un campo personalizado para ingresar números.
 */
@Composable
fun NumberInputField(field: FormField.TextField, state: FormState) {
    var text by remember {
        mutableStateOf(state.fields[field.id]?.value?.value as? String ?: "")
    }
    var error by remember { mutableStateOf<String?>(null) }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it.filter { char -> char.isDigit() } // Solo permitir números
            state.fields[field.id]?.value?.value = text
            error = state.fields[field.id]?.validateAndGetError()
        },
        label = { Text(field.label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        isError = error != null
    )

    error?.let {
        Text(
            text = it,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall
        )
    }
}
