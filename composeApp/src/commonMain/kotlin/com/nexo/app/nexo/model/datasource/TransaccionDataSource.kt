package com.nexo.app.nexo.model.datasource

import com.nexo.app.nexo.model.dto.TransaccionDTO

interface TransaccionDataSource{
    suspend fun obtenerHistorial(idCuenta: Int): List<TransaccionDTO>
    suspend fun registrarMovimiento(transaccion: TransaccionDTO): Boolean

}