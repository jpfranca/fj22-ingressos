package br.com.caelum.ingresso.model;

import br.com.caelum.ingresso.model.descontos.SemDesconto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

public class DescontoTest {

    @Test
    public void naoDeveConcederDescontoParaIngressoNormal() {
        Sala sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
        Filme filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));

        Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
        Ingresso ingresso = new Ingresso(sessao, new SemDesconto());
        BigDecimal precoEsperado = new BigDecimal("32.50");
        Assert.assertEquals(precoEsperado, ingresso.getPreco());
    }
}
