package com.nexo.app.nexo.model.dto

import kotlinx.serialization.Serializable
@Serializable

data class TransaccionDTO (
    val idTranaccion: Int = 0,
    val idCuenta: Int = 0, //Relacion con la cuenta
    val monto: Double,
    val tipo: String, //Ej. "Ingreso" o  "Gasto"
    val concepto: String, //ej. "Pago de renta", "Sueldo"
    val fecha: String // Formato YYYY-MM-DD
)