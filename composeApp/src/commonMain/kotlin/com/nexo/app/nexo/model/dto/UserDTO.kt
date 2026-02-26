package com.nexo.app.nexo.model.dto

import kotlinx.serialization.Serializable
@Serializable
data class UserDTO (
    val idUsuario: Int = 0,
    val nombre: String,
    val correo: String,
    val pinAcceso: String


)