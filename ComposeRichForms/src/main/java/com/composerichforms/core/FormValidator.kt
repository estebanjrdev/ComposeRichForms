package com.composerichforms.core

/**
 * Interfaz para definir validaciones personalizadas en los campos del formulario.
 */
interface Validator {
    fun validate(value: String?): Boolean
    fun getErrorMessage(): String
}

/**
 * Conjunto de validadores listos para usar.
 */
object Validators {
    val Required = object : Validator {
        override fun validate(value: String?): Boolean = !value.isNullOrBlank()
        override fun getErrorMessage(): String = "Este campo es obligatorio"
    }

    val Email = object : Validator {
        override fun validate(value: String?): Boolean =
            value?.matches(Regex("^[A-Za-z0-9+_.-]+@(.+)$")) == true

        override fun getErrorMessage(): String = "Correo electrónico inválido"
    }

    fun MinLength(min: Int) = object : Validator {
        override fun validate(value: String?): Boolean = value?.length ?: 0 >= min
        override fun getErrorMessage(): String = "Debe tener al menos $min caracteres"
    }
}
