package com.nexo.app.nexo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaccion {

    private int idTransaccion;
    private String tipo;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private String concepto;
    private int idCuenta;

    public Transaccion() {}

    // Getters y Setters
}