package com.nexo.app.nexo.dao;

import com.nexo.app.nexo.model.Usuario;
import com.nexo.app.nexo.util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void registrar(Usuario usuario) {

        String sql = "INSERT INTO usuario (nombre, correo, pin_acceso) VALUES (?, ?, ?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getPinAcceso());

            stmt.executeUpdate();
            System.out.println("Usuario registrado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}