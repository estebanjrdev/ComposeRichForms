package com.composerichforms.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composerichforms.core.*

@Composable
fun CheckboxField(field: FormField.Checkbox, state: FormState) {
    var checked by remember {
        mutableStateOf(state.fields[field.id]?.value?.value as? Boolean ?: false)
    }
    var error by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Row {
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = it
                    state.fields[field.id]?.value?.value = it
                    error = state.fields[field.id]?.validateAndGetError()
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = field.label)
        }

        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
