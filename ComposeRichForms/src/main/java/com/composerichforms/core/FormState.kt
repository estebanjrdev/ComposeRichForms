package com.composerichforms.core

/**
 * Clase que gestiona el estado de todos los campos del formulario.
 */
class FormState {
    val fields = mutableMapOf<String, FormFieldState>()

    /**
     * Agrega un nuevo campo al estado del formulario.
     */
    fun addField(id: String, validators: List<Validator>) {
        fields[id] = FormFieldState(validators)
    }

    /**
     * Valida todos los campos del formulario y devuelve `true` si son válidos.
     */
    fun validate(): Boolean {
        return fields.values.all { it.validate() }
    }

    /**
     * Devuelve los datos ingresados en el formulario en un mapa `id -> valor`.
     */
    fun getData(): Map<String, Any?> {
        return fields.mapValues { it.value.value.value }
    }
}
