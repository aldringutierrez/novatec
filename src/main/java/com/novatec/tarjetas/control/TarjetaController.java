package com.novatec.tarjetas.control;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.novatec.tarjetas.model.TarjetaRequest;
import com.novatec.tarjetas.model.TransaccionRequest;
import com.novatec.tarjetas.model.TarjetaResponse;
import com.novatec.tarjetas.servi.TarjetaService;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @GetMapping("/creaDatos")
    public String creaDatos() {
        return tarjetaService.creaDatos();
    }

    @GetMapping("/card/{productId}/number")
    public String getNumero(@PathVariable("productId") long productId) {
        if (productId == 1)
            return "1234-1234-1234-1234";
        else
            return "1111-2222-3333-4444";
    }

    @PostMapping("/card/enrol")
    public ResponseEntity<Long> enrol(@RequestBody TarjetaRequest tarjetaRequest) {
        long tarjetaId = tarjetaService.enrol(tarjetaRequest);
        return new ResponseEntity<>(tarjetaId, HttpStatus.OK);
    }

    @PostMapping("/card/disEnrol")
    public ResponseEntity<Long> disEnrol(@RequestBody TarjetaRequest tarjetaRequest) {
        long tarjetaId = tarjetaService.disenrol(tarjetaRequest);
        return new ResponseEntity<>(tarjetaId, HttpStatus.OK);
    }

    @PostMapping("/card/block")
    public ResponseEntity<Long> block(@RequestBody TarjetaRequest tarjetaRequest) {
        long tarjetaId = tarjetaService.block(tarjetaRequest);
        return new ResponseEntity<>(tarjetaId, HttpStatus.OK);
    }

    @PostMapping("/card/unblock")
    public ResponseEntity<Long> unblock(@RequestBody TarjetaRequest tarjetaRequest) {
        long tarjetaId = tarjetaService.unblock(tarjetaRequest);
        return new ResponseEntity<>(tarjetaId, HttpStatus.OK);
    }

    @PostMapping("/card/balance")
    public ResponseEntity<Long> balance(@RequestBody TarjetaRequest tarjetaRequest) {
        long tarjetaId = tarjetaService.balance(tarjetaRequest);
        return new ResponseEntity<>(tarjetaId, HttpStatus.OK);
    }

    @GetMapping("/card/balance/{tarjetaId}")
    public String getSaldo(@PathVariable("tarjetaId") long tarjetaId) {
        BigDecimal saldo = tarjetaService.getSaldo(tarjetaId);
        return saldo.toPlainString();
    }

    @PostMapping("/transaction/purchase")
    public ResponseEntity<Long> compra(@RequestBody TarjetaRequest tarjetaRequest) {
        long tarjetaId = tarjetaService.compra(tarjetaRequest);
        return new ResponseEntity<>(tarjetaId, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TarjetaResponse> getTarjetaById(@PathVariable("id") long tarjetaId) {
        TarjetaResponse tarjetaResponse
                = tarjetaService.getTarjetaById(tarjetaId);
        return new ResponseEntity<>(tarjetaResponse, HttpStatus.OK);
    }

    @GetMapping("/getById2/{id}")
    public String getTarjetaById2(@PathVariable("id") long tarjetaId) {
        return tarjetaService.getTarjetaById2(tarjetaId);
    }

    @GetMapping("/anular/{id}")
    public String anular(@PathVariable("id") long transaccionId) {
        return tarjetaService.anularTransaccion(transaccionId);
    }

    @PostMapping("/anular2")
    public String anular2(@RequestBody TransaccionRequest transaccionRequest) {
        return tarjetaService.anularTransaccion2(transaccionRequest);
    }
}
