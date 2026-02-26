package com.nexo.app.nexo.model.dto

data class MovimientoDTO (
    val nombre: String,
    val monto: Double,
    val periodicidad : String,  //Semanal, Quincenal, Mensual
    val Esencial: Boolean,  //Validar Gasto esencial y no esencial
    val fecha: String,
    val medio: String  //"Efectivo", "Tarjeta" o "Transferencia"
)