package com.composerichforms.core

/**
 * Clase base para los diferentes tipos de campos en el formulario.
 */
sealed class FormField(
    val id: String,
    val label: String,
    val validators: List<Validator> // Aquí usamos nuestra propia interfaz Validator
) {
    class TextField(id: String, label: String, val placeholder: String, validators: List<Validator>)
        : FormField(id, label, validators)

    class PasswordField(id: String, label: String, validators: List<Validator>)
        : FormField(id, label, validators)

    class Checkbox(id: String, label: String, validators: List<Validator>)
        : FormField(id, label, validators)
}
