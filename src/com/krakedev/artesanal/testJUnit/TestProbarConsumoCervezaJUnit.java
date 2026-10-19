package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestProbarConsumoCervezaJUnit {

    @Test
    public void testConsumirCerveza() {
        NegocioMejorado negocio = new NegocioMejorado();

        // Registrar un cliente y una máquina
        negocio.registrarCliente("Melany", "1755646500");
        negocio.agregarMaquina("Cerveza Roja", "Artesanal", 0.05);

        // Recuperar los objetos registrados
        Cliente cliente = negocio.buscarClientePorCedula("1755646500");
        String codigoMaquina = negocio.getMaquinas().get(0).getCodigo();
        Maquina maquina = negocio.recuperarMaquina(codigoMaquina);

        // Cargar la máquina y consumir 100 ml
        negocio.cargarMaquinas();
        negocio.consumirCerveza(cliente.getCodigo(), codigoMaquina, 100);

        // Validar el cliente, la máquina y los valores
        assertEquals(5.0, cliente.getTotalConsumido(), 0.001);
        assertEquals(9700.0, maquina.getCantidadActual(), 0.001);
        assertEquals(0.05, maquina.getPrecioMl(), 0.001);
    
    }
    
	
}
