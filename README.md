# 📖 ComposeRichForms 🚀  
📌 **Versión:** 1.0.0  
📌 **Repositorio:** [[GitHub URL](https://github.com/estebanjrdev/ComposeRichForms)]  



# 📌 Formularios Dinámicos en Jetpack Compose  
📝 **ComposeRichForms** es una librería open-source para **crear formularios dinámicos con validaciones automáticas** en Jetpack Compose.  

✔️ **Evita código repetitivo**  
✔️ **Maneja el estado automáticamente**  
✔️ **Validaciones personalizadas listas para usar**  
✔️ **Soporte para MVVM y StateFlow**  
✔️ **Fácil de personalizar y extender**  



## 📌 Instalación  

### 1️⃣ Agregar Repositorio en `settings.gradle.kts`
 Para settings.gradle.kts (Kotlin DSL)
```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```
 Para build.gradle (Groovy DSL)
```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
### 2️⃣ Agregar Dependencia en `build.gradle.kts`
 Para settings.gradle.kts (Kotlin DSL)
```kotlin
dependencies {
    implementation("com.github.estebanjrdev:ComposeRichForms:1.0.0")
}
```
 Para build.gradle (Groovy DSL)
```kotlin
dependencies {
    implementation 'com.github.estebanjrdev:ComposeRichForms:1.0.0'
}
```
### 3️⃣ Uso Básico 🚀

Ejemplo de Formulario con Validaciones
```kotlin
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
    Log.d("Formulario", "Datos enviados: $formData")
}
```
✔️ Los campos se validan automáticamente.

✔️ Si hay errores, se muestran en la interfaz.

✔️ Si todo es válido, los datos se envían como `Map<String, Any?>`.



### 4️⃣ Validaciones Disponibles 
La librería incluye validaciones listas para usar.

| **Validador**             | **Descripción**                        | **Ejemplo**                              |
|---------------------------|--------------------------------------|------------------------------------------|
| `Validators.Required`     | Campo obligatorio                   | `listOf(Validators.Required)`           |
| `Validators.Email`        | Verifica que sea un correo válido   | `listOf(Validators.Email)`              |
| `Validators.MinLength(6)` | Longitud mínima de caracteres       | `listOf(Validators.MinLength(6))`       |
| `Validators.Regex("[0-9]+")` | Valida con una expresión regular | `listOf(Validators.Regex("[0-9]+"))`    |

Ejemplo con Múltiples Validaciones
```kotlin
val fields = listOf(
    FormField.TextField("username", "Usuario", "Ejemplo123", listOf(Validators.Required, Validators.MinLength(5))),
    FormField.TextField("phone", "Teléfono", "+52123456789", listOf(Validators.Regex("\\+\\d{12}")))
)
```
### 5️⃣ Personalización de Estilos 🎨
Puedes personalizar el botón de envío y otros componentes de la UI.

Ejemplo: Cambiar el Color del Botón
```kotlin
ComposeRichForm(
    state = formState,
    fields = fields,
    buttonColor = Color.Red // Cambia el color del botón
)
```
### 6️⃣ Integración con `ViewModel` y `StateFlow`
La librería es compatible con la arquitectura MVVM.

Ejemplo con `ViewModel`
```kotlin
class FormViewModel : ViewModel() {
    val formState = MutableStateFlow(FormState())
}
```
En la UI:
```kotlin
val viewModel: FormViewModel = viewModel()
ComposeRichForm(state = viewModel.formState.collectAsState().value, fields = fields) { formData ->
    viewModel.submitForm(formData)
}
```
### 7️⃣ Cómo Extender la Librería 🚀
Si necesitas un nuevo tipo de campo (Ej: un campo de solo números), puedes crearlo fácilmente sin modificar la librería.

Ejemplo: Campo de Números
```kotlin
@Composable
fun NumberInputField(field: FormField.TextField, state: FormState) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it.filter { char -> char.isDigit() } }, // Solo permite números
        label = { Text(field.label) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
}
```
Luego solo lo usas en el formulario:
```kotlin
FormField.TextField("age", "Edad", "25", listOf(Validators.Required))
```
### Contribuir 👨‍💻
Si quieres mejorar ComposeRichForms, ¡toda ayuda es bienvenida!

🔹 Cómo Contribuir

Haz un Fork de este repositorio.

Crea una rama con tu feature o corrección.

Haz un Pull Request (PR) explicando los cambios.

### Contacto y Soporte 🚀
📌 Si tienes dudas, abre un issue en GitHub o envíame un mensaje en:

📩 [contacto@estebanjrdev.com]

💼 [[LinkedIn](https://www.linkedin.com/in/estebanjrdev)] 


🔥 Si te gustó la librería, dale ⭐ en GitHub y compártela con otros desarrolladores!
