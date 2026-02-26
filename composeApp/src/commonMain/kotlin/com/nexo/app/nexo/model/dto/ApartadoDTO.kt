package com.nexo.app.nexo.model.dto

import kotlinx.serialization.Serializable
@Serializable

data class ApartadoDTO (
    val nombre: String,
    val meta: Double,
    val fecha: String
)