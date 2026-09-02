package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoCliente {
	@Test
	public void asignarCodigo(){
	
		Negocio barDeMoe = new Negocio();
		Cliente mario = new Cliente("Mario", "544454534");
		Cliente juan = new Cliente("Juan", "543587888");
		
		barDeMoe.asignarCodigoCliente(mario);
		barDeMoe.asignarCodigoCliente(juan);
		
		assertEquals(100,mario.getCodigo());
		assertEquals(101,juan.getCodigo());
	}
}
