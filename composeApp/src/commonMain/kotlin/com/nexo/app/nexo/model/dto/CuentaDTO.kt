package com.nexo.app.nexo.model.dto

import kotlinx.serialization.Serializable
@Serializable
data class CuentaDTO (
    val idCuenta: Int = 0,
    val idUsuario: Int = 0, //Relacion con el usuario
    val nombreCuenta: String, //Ej: "Ahorros", "Nómina"
    val saldo: Double=0.0,
    val tipoCuenta: String
)