package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquinaMejoradoJUnit {


    @Test
    public void testAgregarMaquina() {

    NegocioMejorado negocio = new NegocioMejorado();

    boolean resultado = negocio.agregarMaquina(
        "Cerveza Roja",
        "Cerveza artesanal roja",
        0.05
    );

    assertTrue(resultado);
    assertEquals(1, negocio.getMaquinas().size());
}


    @Test
    public void testAgregarMaquinaDuplicada() {

    NegocioMejorado negocio = new NegocioMejorado() {
        @Override
        public String generarCodigo() {
            return "M-25";
        }
    };

    boolean resultado1 = negocio.agregarMaquina(
        "Cerveza Roja",
        "Cerveza artesanal roja",
        0.05
    );

    boolean resultado2 = negocio.agregarMaquina(
        "Cerveza Rubia",
        "Cerveza artesanal rubia",
        0.04
    );

    assertTrue(resultado1);
    assertFalse(resultado2);
    assertEquals(1, negocio.getMaquinas().size());
}

}
