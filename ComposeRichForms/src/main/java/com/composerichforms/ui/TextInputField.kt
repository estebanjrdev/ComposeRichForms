package com.composerichforms.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.composerichforms.core.*

@Composable
fun TextInputField(field: FormField.TextField, state: FormState) {
    var text by remember {
        mutableStateOf(
            TextFieldValue(state.fields[field.id]?.value?.value as? String ?: "")
        )
    }
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
            keyboardOptions = KeyboardOptions.Default,
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
