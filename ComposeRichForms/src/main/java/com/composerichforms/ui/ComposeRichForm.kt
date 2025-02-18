import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composerichforms.core.FormField
import com.composerichforms.core.FormState
import com.composerichforms.ui.CheckboxField
import com.composerichforms.ui.TextInputField
import com.composerichforms.ui.PasswordField

@Composable
fun ComposeRichForm(
    state: FormState,
    fields: List<FormField>,
    onSubmit: (Map<String, Any?>) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        fields.forEach { field ->
            state.addField(field.id, field.validators) // Agregar cada campo al estado global

            when (field) {
                is FormField.TextField -> TextInputField(field, state)
                is FormField.PasswordField -> PasswordField(field, state)
                is FormField.Checkbox -> CheckboxField(field, state)
            }
        }

        Button(
            onClick = {
                if (state.validate()) {
                    onSubmit(state.getData())
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}
