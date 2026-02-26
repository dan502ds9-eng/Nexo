package com.nexo.app.nexo.model.repository

import com.nexo.app.nexo.model.datasource.TransaccionDataSource
import com.nexo.app.nexo.model.dto.TransaccionDTO

class TransaccionRepository(private val dataSource: TransaccionDataSource) {
    suspend fun verMovimientos(idCuenta: Int): List<TransaccionDTO>{
        return dataSource.obtenerHistorial(idCuenta)
    }
    suspend fun nuevoMovimiento(transaccion: TransaccionDTO): Boolean{
        return dataSource.registrarMovimiento(transaccion)
    }
}