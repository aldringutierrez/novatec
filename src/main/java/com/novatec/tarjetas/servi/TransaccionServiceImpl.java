package com.novatec.tarjetas.servi;

import com.novatec.tarjetas.entity.Tarjeta;
import com.novatec.tarjetas.entity.Transaccion;
import com.novatec.tarjetas.exception.TarjetaNotFoundException;
import com.novatec.tarjetas.exception.TransaccionNotFoundException;
import com.novatec.tarjetas.repo.TarjetaRepository;
import com.novatec.tarjetas.repo.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class TransaccionServiceImpl implements TransaccionService {
        private TransaccionRepository transaccionRepository;
        private TarjetaRepository tarjetaRepository;

        @Autowired
        public TransaccionServiceImpl(TransaccionRepository transaccionRepository, TarjetaRepository tarjetaRepository) {
            this.transaccionRepository = transaccionRepository;
            this.tarjetaRepository = tarjetaRepository;
        }

        @Override
        public Transaccion createTransaccion(Long tarjetaId, Transaccion Transaccion) {
            Transaccion transaccion = new Transaccion();

            Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).orElseThrow(() -> new TarjetaNotFoundException("Tarjeta with associated transaccion not found"));

            transaccion.setTarjeta(tarjeta);

            Transaccion newTransaccion = transaccionRepository.save(transaccion);

            return newTransaccion;
        }

        @Override
        public List<Transaccion> getTransaccionesByTarjetaId(Long tarjetaid) {
            List<Transaccion> transaccions = transaccionRepository.findByTarjetaId(tarjetaid);

            return transaccions;
//            return transaccions.stream().map(transaccion -> mapToDto(transaccion)).collect(Collectors.toList());
        }

        @Override
        public Transaccion getTransaccionById(Long transaccionId, Long tarjetaId) {
            Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).orElseThrow(() -> new TarjetaNotFoundException("Tarjeta with associated transaccion not found"));

            Transaccion transaccion = transaccionRepository.findById(transaccionId).orElseThrow(() -> new TransaccionNotFoundException("Transaccion with associate tarjeta not found"));

            if(transaccion.getTarjeta().getId() != tarjeta.getId()) {
                throw new TransaccionNotFoundException("This transaccion does not belond to a tarjeta");
            }

            return transaccion;
        }

        @Override
        public Transaccion updateTransaccion(Long tarjetaId, Long transaccionId, Transaccion transaccion) {
            Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).orElseThrow(() -> new TarjetaNotFoundException("Tarjeta with associated transaccion not found"));

            Transaccion transaccion2 = transaccionRepository.findById(transaccionId).orElseThrow(() -> new TransaccionNotFoundException("Transaccion with associate tarjeta not found"));

            if(transaccion.getTarjeta().getId() != tarjeta.getId()) {
                throw new TransaccionNotFoundException("This transaccion does not belong to a tarjeta");
            }

            transaccion.setTipo(transaccion2.getTipo());
            transaccion.setValor(transaccion2.getValor());

            Transaccion updateTransaccion = transaccionRepository.save(transaccion);

            return updateTransaccion;
        }

        @Override
        public void deletetransaccion(Long tarjetaId, Long transaccionId) {

        }
/*
        @Override
        public void deleteTransaccion(int tarjetaId, int transaccionId) {
            Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId).orElseThrow(() -> new TarjetaNotFoundException("Tarjeta with associated transaccion not found"));

            Transaccion transaccion = transaccionRepository.findById(transaccionId).orElseThrow(() -> new TransaccionNotFoundException("Transaccion with associate tarjeta not found"));

            if(transaccion.getTarjeta().getId() != tarjeta.getId()) {
                throw new TransaccionNotFoundException("This transaccion does not belong to a tarjeta");
            }

            transaccionRepository.delete(transaccion);
        }

        private TransaccionDto mapToDto(Transaccion transaccion) {
            TransaccionDto transaccionDto = new TransaccionDto();
            transaccionDto.setId(transaccion.getId());
            transaccionDto.setTitle(transaccion.getTitle());
            transaccionDto.setContent(transaccion.getContent());
            transaccionDto.setStars(transaccion.getStars());
            return transaccionDto;
        }

        private Transaccion mapToEntity(TransaccionDto transaccionDto) {
            Transaccion transaccion = new Transaccion();
            transaccion.setId(transaccionDto.getId());
            transaccion.setTitle(transaccionDto.getTitle());
            transaccion.setContent(transaccionDto.getContent());
            transaccion.setStars(transaccionDto.getStars());
            return transaccion;
        }
*/
    }

