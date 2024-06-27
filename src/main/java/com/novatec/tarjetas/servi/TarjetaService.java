package com.novatec.tarjetas.servi;

import java.math.BigDecimal;

import com.novatec.tarjetas.model.TarjetaRequest;
import com.novatec.tarjetas.model.TarjetaResponse;
import com.novatec.tarjetas.model.TransaccionRequest;

public interface TarjetaService {
    String creaDatos();

    long enrol(TarjetaRequest tarjetaRequest);

    long disenrol(TarjetaRequest tarjetaRequest);

    long block(TarjetaRequest tarjetaRequest);

    long unblock(TarjetaRequest tarjetaRequest);

    long balance(TarjetaRequest tarjetaRequest);

    BigDecimal getSaldo(Long tarjetaId);

    long compra(TarjetaRequest tarjetaRequest);

    TarjetaResponse getTarjetaById(long tarjetaId);

    String getTarjetaById2(long tarjetaId);

    String anularTransaccion(long transaccionId);

    String anularTransaccion2(TransaccionRequest transaccionRequest);

}
