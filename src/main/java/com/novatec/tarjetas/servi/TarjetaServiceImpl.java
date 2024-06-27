package com.novatec.tarjetas.servi;
import com.novatec.tarjetas.entity.Transaccion;
import com.novatec.tarjetas.exception.TransaccionNotFoundException;
import com.novatec.tarjetas.model.TransaccionRequest;
import com.novatec.tarjetas.repo.TransaccionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novatec.tarjetas.entity.Tarjeta;
import com.novatec.tarjetas.exception.TarjetaServiceCustomException;
import com.novatec.tarjetas.model.TarjetaRequest;
import com.novatec.tarjetas.model.TarjetaResponse;
import com.novatec.tarjetas.repo.TarjetaRepository;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
@Log4j2
public class TarjetaServiceImpl implements TarjetaService{
    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Autowired
    private TransaccionRepository transaccionRepository;
    @Override
    public String creaDatos() {
        log.info("crea datos... ");
        Tarjeta tarjeta
                = Tarjeta.builder()
                .nombreTitular("aldrin")
                .estadoActivacion("N")
                .saldo(new BigDecimal(20000))
                .build();
        List<Transaccion> lstTransaccion = new ArrayList<Transaccion>();

        Timestamp tmp1 = new Timestamp(System.currentTimeMillis()-43400000);
        Timestamp tmp2 = new Timestamp(System.currentTimeMillis()-2*86400000);

        Transaccion transaccion1 = Transaccion.builder()
                .tipo("C")
                .valor(new BigDecimal(800))
                .fechaTran(tmp1)
                .tarjeta(tarjeta)
                .build();
        lstTransaccion.add(transaccion1);
        Transaccion transaccion2 = Transaccion.builder()
                .tipo("D")
                .valor(new BigDecimal(850))
                .fechaTran(tmp2)
                .tarjeta(tarjeta)
                .build();
        lstTransaccion.add(transaccion2);
        tarjeta.setTransacciones(lstTransaccion);
        tarjeta = tarjetaRepository.save(tarjeta);
        log.info("crea datos : "+tarjeta.getId());
        return "ok";
    }

    @Override
    public long enrol(TarjetaRequest tarjetaRequest) {
        log.info("Activando Tarjeta... "+tarjetaRequest.getTarjetaId() );
        long id = tarjetaRequest.getTarjetaId();
        Tarjeta tarjeta
                = tarjetaRepository.findById(id)
                .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
        tarjeta.setEstadoActivacion("S");
        tarjetaRepository.  save(tarjeta);
        log.info("Tarjeta activada "+tarjeta.getNombreTitular());
        return 1;
    }

    @Override
    public long disenrol(TarjetaRequest tarjetaRequest) {
       log.info("desactivando Tarjeta... "+tarjetaRequest.getTarjetaId() );
       long id = tarjetaRequest.getTarjetaId();
       Tarjeta tarjeta
               = tarjetaRepository.findById(id)
               .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
       tarjeta.setEstadoActivacion("N");
       tarjetaRepository.  save(tarjeta);
       log.info("Tarjeta desactivada "+tarjeta.getNombreTitular());
       return 1;
    }

    @Override
    public long block(TarjetaRequest tarjetaRequest) {
       log.info("bloqueando Tarjeta... "+tarjetaRequest.getTarjetaId() );


       long id = tarjetaRequest.getTarjetaId();
       Tarjeta tarjeta
               = tarjetaRepository.findById(id)
               .orElseThrow(
                       () -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));

       tarjeta.setEstadoBloqueo("S");
       tarjetaRepository.  save(tarjeta);
       log.info("Tarjeta bloqueada "+tarjeta.getNombreTitular());
       return 1;
    }

    @Override
    public long unblock(TarjetaRequest tarjetaRequest) {
       log.info("desbloqueando Tarjeta... "+tarjetaRequest.getTarjetaId() );
       long id = tarjetaRequest.getTarjetaId();
       Tarjeta tarjeta
               = tarjetaRepository.findById(id)
               .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND  "+id));
       tarjeta.setEstadoBloqueo("N");
       tarjetaRepository.  save(tarjeta);
       log.info("Tarjeta desbloqueada "+tarjeta.getNombreTitular());
       return 1;
    }

    @Override
    public long balance(TarjetaRequest tarjetaRequest) {
       log.info("balance   tarjetaid... "+tarjetaRequest.getTarjetaId() );
       long id = tarjetaRequest.getTarjetaId();
       BigDecimal balance = tarjetaRequest.getSaldo();
       log.info("balance... "+balance );
       Tarjeta tarjeta
               = tarjetaRepository.findById(id)
               .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
       balance = balance.add(tarjetaRequest.getSaldo());
       tarjeta.setSaldo(balance);
       tarjetaRepository.  save(tarjeta);
       log.info("Saldo nuevo : "+balance);
       return 1;
    }

    @Override
    public BigDecimal getSaldo(Long tarjetaId) {
       log.info("getSaldo   tarjetaid... "+tarjetaId );
       Tarjeta tarjeta
               = tarjetaRepository.findById(tarjetaId)
               .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
       log.info("Saldo nuevo : "+tarjeta.getSaldo());
       return tarjeta.getSaldo();
    }

    @Override
    public long compra(TarjetaRequest tarjetaRequest) {
       log.info("compra   tarjetaid... "+tarjetaRequest.getTarjetaId() );
       long id = tarjetaRequest.getTarjetaId();
       BigDecimal balance = tarjetaRequest.getSaldo();
       log.info("balance... "+balance );
       Tarjeta tarjeta
               = tarjetaRepository.findById(id)
               .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
       balance = tarjetaRequest.getSaldo().subtract(tarjetaRequest.getPrice());
       tarjeta.setSaldo(balance);
       tarjetaRepository.  save(tarjeta);
       log.info("Saldo nuevo : "+balance);
       return 1;
    }

    @Override
    public TarjetaResponse getTarjetaById(long tarjetaId) {
        log.info("Get the Tarjeta for TarjetaId: {}", tarjetaId);
        Tarjeta tarjeta
                = tarjetaRepository.findById(tarjetaId)
                .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
        TarjetaResponse tarjetaResponse = new TarjetaResponse();
        log.info("transacciones : "+tarjeta.getTransacciones().size());
        //copyProperties(tarjeta, tarjetaResponse);
        return tarjetaResponse;
    }
    public String getTarjetaById2(long tarjetaId) {
        log.info("Get the Tarjeta for TarjetaId: {}", tarjetaId);
        Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId)
                .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
        log.info("transacciones : "+tarjeta.getTransacciones().size());
        String tmp = "Tarjeta : "+"\n"+
                "numero : "+tarjeta.getId()+
                " Nombre : "+tarjeta.getNombreTitular()+
                " saldo : "+tarjeta.getSaldo()+"\n"+
                "Transacciones : "+"\n"+
                "numero : "+tarjeta.getTransacciones().get(0).getTransaccionId()+
                " tipo  :  "+tarjeta.getTransacciones().get(0).getTipo()+
                " valor :  "+tarjeta.getTransacciones().get(0).getValor()+"\n"+
                "numero : "+tarjeta.getTransacciones().get(1).getTransaccionId()+
                " tipo  :  "+tarjeta.getTransacciones().get(1).getTipo()+
                " valor :  "+tarjeta.getTransacciones().get(1).getValor()+"\n";
        return tmp;
    }
    public String anularTransaccion(long transaccionId) {
        log.info("anularTransaccion transaccionId : "+transaccionId);
        Transaccion transaccion = transaccionRepository.findById(transaccionId)
                .orElseThrow(() -> new TransaccionNotFoundException("Transaccion with given id not found"));
        Tarjeta tarjeta = tarjetaRepository.findById(transaccion.getTarjeta().getId())
                .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
        long ahora = new Date().getTime();
        long tmp1 = transaccion.getFechaTran().getTime();
        tmp1 = ahora-tmp1;
        if (86400000-tmp1<0) {
            log.info("tmp1 mas de 24h  {} ", 86400000 - tmp1);
            return " no se puede anular la transaccion. motivo : mayor a 24 horas ";
        } else {
            transaccion.setEstado("A");
            transaccion = transaccionRepository.save(transaccion);
            tarjeta.setSaldo(tarjeta.getSaldo().add(transaccion.getValor()));
            tarjeta = tarjetaRepository.save(tarjeta);
        }
        return " transaccion anulada ";
    }

    public String anularTransaccion2(TransaccionRequest transaccionRequest) {
        log.info("anularTransaccion tarjetaId : "+transaccionRequest.getTarjetaId());
        Tarjeta tarjeta = tarjetaRepository.findById(transaccionRequest.getTarjetaId())
                .orElseThrow(() -> new TarjetaServiceCustomException("Tarjeta with given id not found","TARJETA_NOT_FOUND"));
        log.info(" *** encontrada tarjeta.getTransacciones().size : "+tarjeta.getTransacciones().size());
        for(Transaccion tra : tarjeta.getTransacciones()){
            if(tra.getTransaccionId().equals(transaccionRequest.getTransaccionId())){
               log.info(" *** encontrada : ");
                long ahora = new Date().getTime();
                long tmp1 = tra.getFechaTran().getTime();
                tmp1 = ahora-tmp1;
                if (86400000-tmp1<0) {
                    log.info("tmp1 mas de 24h  {} ", 86400000 - tmp1);
                    return " no se puede anular la transaccion. motivo : mayor a 24 horas ";
                }
                tra.setEstado("A");
                tarjeta.setSaldo(tarjeta.getSaldo().add(tra.getValor()));
                tarjeta = tarjetaRepository.save(tarjeta);
            }
        }
        return " transaccion anulada ";
    }

}
