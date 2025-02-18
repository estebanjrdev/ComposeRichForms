package com.composerichforms.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.composerichforms.core.*

@Composable
fun PasswordField(field: FormField.PasswordField, state: FormState) {
    var text by remember {
        mutableStateOf(
            TextFieldValue(state.fields[field.id]?.value?.value as? String ?: "")
        )
    }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                state.fields[field.id]?.value?.value = it.text
                error = state.fields[field.id]?.validateAndGetError()
            },
            label = { Text(field.label) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (isPasswordVisible) "🙈" else "👁️"
                TextButton(onClick = { isPasswordVisible = !isPasswordVisible }) { Text(icon) }
            },
            modifier = Modifier.fillMaxWidth(),
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
}
