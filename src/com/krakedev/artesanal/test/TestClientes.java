package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		NegocioMejorado c1 = new NegocioMejorado();
		c1.registrarCliente("Melany", "1766434698");
		
		Cliente encontrado = c1.buscarClientePorCodigo(100);

		if (encontrado != null) {
		    System.out.println(encontrado.getNombre());
		} else {
		    System.out.println("Cliente no encontrado");
		}
	}

}
