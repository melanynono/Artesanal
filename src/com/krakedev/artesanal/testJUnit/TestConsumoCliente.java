package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumoCliente {
	
	@Test
	public void probarCondumo() {
		
		Maquina maquinaA = new Maquina("Pilsener", "Rubia",0.002,8000, "6535");
		
		Negocio barDeMoe = new Negocio("Bar de Moe", maquinaA);
		
		Cliente cliente = new Cliente("Melany", "1755646500");
		
		barDeMoe.cargarMaquinaA();
		barDeMoe.consumirCervezaMaquinaA(cliente, 100);
		
		assertEquals(7700,maquinaA.getCantidadActual(), 0.0001);
		assertEquals(0.2, cliente.getTotalConsumido(), 0.0001);
		
		barDeMoe.consumirCervezaMaquinaA(cliente, 200);
		
		assertEquals(7500,maquinaA.getCantidadActual(), 0.0001);
		assertEquals(0.6, cliente.getTotalConsumido(), 0.0001);
	}
	
	//Prueba consultarValorVendido
	

    @Test
    public void testConsultarValorVendido() {
    NegocioMejorado negocio = new NegocioMejorado();

    negocio.registrarCliente("Melany", "1755646500");
    negocio.registrarCliente("Luis", "0987654321");

    // Registrar los consumos de ambos clientes
    negocio.registrarConsumo(100, 5.0);
    negocio.registrarConsumo(101, 3.5);

    double total = negocio.consultarValorVendido();

    assertEquals(8.5, total, 0.001);
    
    
    }
    

   @Test
   public void testConsultarValorVendidoTresClientes() {
    NegocioMejorado negocio = new NegocioMejorado();

    negocio.registrarCliente("Melany", "1755646500");
    negocio.registrarCliente("Luis", "0987654321");
    negocio.registrarCliente("Pedro", "1122334455");

    negocio.registrarConsumo(100, 10.0);
    negocio.registrarConsumo(101, 5.5);
    // Pedro todavia no tiene consumos

    double total = negocio.consultarValorVendido();

    assertEquals(15.5, total, 0.001);
   }



}
