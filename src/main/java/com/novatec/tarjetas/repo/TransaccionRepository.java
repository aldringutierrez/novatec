package com.novatec.tarjetas.repo;

import com.novatec.tarjetas.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


    public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
        Transaccion findByTransaccionId(Long transaccionId);
        List<Transaccion> findByTarjetaId(Long tarjetaId);
    }


