package com.nexo.app.nexo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nexo.app.nexo.model.datasource.CuentaDataSource
import com.nexo.app.nexo.model.datasource.DataSource
import com.nexo.app.nexo.model.dto.ApartadoDTO
import com.nexo.app.nexo.model.dto.CuentaDTO
import com.nexo.app.nexo.model.dto.MovimientoDTO
import com.nexo.app.nexo.model.dto.UserDTO
import com.nexo.app.nexo.model.repository.CuentaRepository
import com.nexo.app.nexo.ui.screens.RegistroScreen
import com.nexo.app.nexo.viewModel.RegistroViewModel
import com.nexo.app.nexo.model.repository.UserRepository
import com.nexo.app.nexo.ui.screens.HomeScreen
import com.nexo.app.nexo.viewModel.HomeViewModel

@Composable
fun App() {
    // 1. Estado para saber si el usuario ya entró a la app
    var usuarioLogueado by remember { mutableStateOf(false) }

    MaterialTheme {
        //1.- Instanciamos la cadena de responsabilidades(Temporalmente manual)
        //Sustituir 'UserDataSourceImpl()' por la clase real de datos
        val userRepository = UserRepository(dataSource = UserDataSourceImpl())
        val cuentaRepository = CuentaRepository(dataSource = CuentaDataSourceImpl())

        val registroViewModel = RegistroViewModel(repository = userRepository)
        val homeVM = HomeViewModel(repository = cuentaRepository)

        //2.- Llamamos a la pantalla y le pasamos el ViewModel

        if (!usuarioLogueado) {
            //Si no ha entrado, mostramos Registro o iniciar sesión
            RegistroScreen(viewModel = registroViewModel)
            val exito by registroViewModel.registroExitoso.collectAsState()
            if (exito == true) {
                usuarioLogueado = true
            } else {
                //Si ya se registró, mostrar menú
                HomeScreen(viewModel = homeVM)
            }
        }
    }
}

class UserDataSourceImpl : DataSource.UserRemoteDataSource {
    override suspend fun validarCorreo(correo: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun save(user: UserDTO): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun registerUser(user: UserDTO): Result<UserDTO> {
        //Simulando registro siempre exitoso por ahora
        return Result.success(user)
    }

    override suspend fun guardarMovimiento(gasto: MovimientoDTO) {
        TODO("Not yet implemented")
    }

    override suspend fun guardarApartado(apartado: ApartadoDTO) {
        TODO("Not yet implemented")
    }
}

// 2. Implementación de prueba para Cuentas
class CuentaDataSourceImpl : CuentaDataSource {
    override suspend fun obtenerCuentasPorUsuario(idUsuario: Int): List<CuentaDTO> {
        return listOf(
            CuentaDTO(1, idUsuario, "Ahorros Personal", 1500.0, "Débito"),
            CuentaDTO(2, idUsuario, "Tarjeta de Crédito", -200.50, "Crédito")
        )
    }

    override suspend fun obtenerCuentasPorusuario(idUsuario: Int): List<CuentaDTO> {
        TODO("Not yet implemented")
    }

    // Métodos obligatorios de la interfaz (pueden estar vacíos por ahora)
    override suspend fun crearCuenta(cuenta: CuentaDTO): Boolean = true
    override suspend fun actualizarSaldo(idCuenta: Int, nuevoSaldo: Double): Boolean = true
}
