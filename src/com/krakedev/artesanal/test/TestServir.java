package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000);
		System.out.println("-------Estado inicial------");
		rubia.imprimir();
		
		System.out.println("-------Llenando maquina------");
		rubia.llenarMaquina();
		rubia.imprimir();
		
		System.out.println("-------Servir 1000 Ml------");
		double valor;
		valor = rubia.servirCerveza(1000);
		System.out.println("Valor a pagar: "+ valor);
		
		
		System.out.println("-------Servir 2000 Ml------");;
		valor = rubia.servirCerveza(2000);
		System.out.println("Valor a pagar: "+ valor);
		
		
		rubia.imprimir();
		
		System.out.println("-------Servir 6000 Ml------");
		valor = rubia.servirCerveza(6000);
		System.out.println("Valor a pagar: "+ valor);
		rubia.imprimir();
		
	}

}
