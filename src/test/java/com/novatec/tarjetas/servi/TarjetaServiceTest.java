package com.novatec.tarjetas.servi;

import com.novatec.tarjetas.entity.Tarjeta;
import com.novatec.tarjetas.model.TarjetaResponse;
import com.novatec.tarjetas.repo.TarjetaRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.stubbing.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

	@ExtendWith(MockitoExtension.class)
	public 	class TarjetaServiceTest {

    @Mock
    private TarjetaService tarjetaService=Mockito.mock(TarjetaService.class);;

	    @Test
	    public void TarjetaService_CreateTarjeta_ReturnsTarjeta() {
	        Tarjeta tarjeta = Tarjeta.builder()
	                .nombreTitular("fernanda")
	                .saldo(new BigDecimal(5000)).build();
	        Assertions.assertThat(tarjeta).isNotNull();
	    }

	    @Test
	    public void TarjetService_GetAllTarjet_ReturnsOK() {
	        Tarjeta tarjeta = Tarjeta.builder()
              .nombreTitular("fernanda")
              .id((long)1)
              .saldo(new BigDecimal(5000)).build();
	        Assertions.assertThat(tarjeta.getNombreTitular().equalsIgnoreCase("fernanda"));
	    }

	    @Test
	    public void TarjetService_qq_ReturnsOK() {
	        Tarjeta tarjeta = Tarjeta.builder()
              .nombreTitular("fernanda")
              .id((long)1)
              .saldo(new BigDecimal(5000)).build();
	        when(tarjetaService.getSaldo(Mockito.any(Long.class))).thenReturn(new BigDecimal(5000));
	        Assertions.assertThat(tarjetaService.getSaldo(Mockito.any(Long.class)).equals(5000));
	    }
	}
