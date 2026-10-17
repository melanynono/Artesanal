package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquinaJUnit {

	

@Test
public void testRecuperarMaquinaExistente() {

    NegocioMejorado negocio = new NegocioMejorado();

    // Agregar una máquina
    negocio.agregarMaquina(
        "Cerveza Roja",
        "Cerveza artesanal",
        0.05
    );

    // Obtener el código de la máquina agregada
    String codigo = negocio.getMaquinas().get(0).getCodigo();

    // Buscar la máquina por su código
    Maquina maquinaEncontrada = negocio.recuperarMaquina(codigo);

    // Verificar que se encontró la máquina correcta
    assertNotNull(maquinaEncontrada);
    assertEquals("Cerveza Roja", maquinaEncontrada.getNombreCerveza());
    assertEquals(codigo, maquinaEncontrada.getCodigo());
}

@Test
public void testRecuperarMaquinaInexistente() {

    NegocioMejorado negocio = new NegocioMejorado();

    // Buscar un código que no puede generar el método
    Maquina maquinaEncontrada = negocio.recuperarMaquina("M-999");

    // Verificar que no se encontró ninguna máquina
    assertNull(maquinaEncontrada);
}

	
}
