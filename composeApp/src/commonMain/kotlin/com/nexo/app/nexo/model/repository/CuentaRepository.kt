package com.nexo.app.nexo.model.repository

import com.nexo.app.nexo.model.datasource.CuentaDataSource
import com.nexo.app.nexo.model.dto.CuentaDTO

class CuentaRepository(private val dataSource: CuentaDataSource) {

    suspend fun listarMisCuentas(idUsuario: Int): List<CuentaDTO> {
        return dataSource.obtenerCuentasPorusuario(idUsuario)
    }
    suspend fun registrarNuevaCuenta(cuenta: CuentaDTO): Boolean{
        return dataSource.crearCuenta(cuenta)
    }
}