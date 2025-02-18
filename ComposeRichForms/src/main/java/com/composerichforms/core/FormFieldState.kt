package com.composerichforms.core

import androidx.compose.runtime.mutableStateOf

/**
 * Clase que representa el estado de un campo en el formulario.
 */
class FormFieldState(private val validators: List<Validator>) {
    var value = mutableStateOf<Any?>(null)
    var errorMessage = mutableStateOf<String?>(null)

    /**
     * Valida el campo utilizando la lista de validadores asignados.
     * Si hay errores, los almacena en `errorMessage`.
     */
    fun validate(): Boolean {
        for (validator in validators) {
            if (!validator.validate(value.value?.toString())) {
                errorMessage.value = validator.getErrorMessage()
                return false
            }
        }
        errorMessage.value = null
        return true
    }

    /**
     * Valida el campo y devuelve el mensaje de error si lo hay.
     */
    fun validateAndGetError(): String? {
        validate()
        return errorMessage.value
    }
}
