package com.novatec.tarjetas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novatec.tarjetas.entity.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
}
