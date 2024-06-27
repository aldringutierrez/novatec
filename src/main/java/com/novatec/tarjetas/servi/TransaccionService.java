package com.novatec.tarjetas.servi;

import com.novatec.tarjetas.entity.Transaccion;

import java.util.List;

    public interface TransaccionService {
        Transaccion createTransaccion(Long tarjetaId, Transaccion transaccion);
        List<Transaccion> getTransaccionesByTarjetaId(Long id);
        Transaccion getTransaccionById(Long transaccionId, Long tarjetaId);
        Transaccion updateTransaccion(Long tarjetaId, Long transaccionId, Transaccion transaccion);
        void deletetransaccion(Long tarjetaId, Long transaccionId);
    }
