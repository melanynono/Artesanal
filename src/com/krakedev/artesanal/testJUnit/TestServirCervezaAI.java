package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {

private static final double TOLERANCIA = 0.0001;

@Test
public void testServirCantidadMenorDisponibleConstructorCompleto() {
	// Se utiliza el constructor con capacidad máxima personalizada.
	Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000);

	// Se carga cerveza en la máquina.
	maquina.recargarCerveza(500);

	// Se intenta servir una cantidad menor a la disponible.
	double valor = maquina.servirCerveza(200);

	// Valida que el valor a pagar sea cantidad servida por precio por ml.
	assertEquals(10.0, valor, TOLERANCIA);

	// Valida que la cantidad servida se haya restado correctamente.
	assertEquals(300.0, maquina.getCantidadActual(), TOLERANCIA);
}

@Test
public void testServirExactamenteCantidadDisponible() {
	// Se utiliza el constructor con capacidad máxima personalizada.
	Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000);

	// Se carga una cantidad específica de cerveza.
	maquina.recargarCerveza(500);

	// Se sirve exactamente toda la cerveza disponible.
	double valor = maquina.servirCerveza(500);

	// Valida que el valor a pagar sea correcto.
	assertEquals(25.0, valor, TOLERANCIA);

	// Valida que la cantidad actual quede en cero.
	assertEquals(0.0, maquina.getCantidadActual(), TOLERANCIA);
}

@Test
public void testNoServirCuandoNoHaySuficienteCerveza() {
	// Se utiliza el constructor con capacidad máxima personalizada.
	Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", 0.05, 1000);

	// Se carga una cantidad menor a la que se desea servir.
	maquina.recargarCerveza(300);

	// Se intenta servir más cerveza de la disponible.
	double valor = maquina.servirCerveza(400);

	// Valida que no se cobre nada cuando no se puede servir.
	assertEquals(0.0, valor, TOLERANCIA);

	// Valida que la cantidad actual no cambie.
	assertEquals(300.0, maquina.getCantidadActual(), TOLERANCIA);
}

@Test
public void testServirCervezaUsandoConstructorSinCapacidad() {
	// Se utiliza el constructor que establece una capacidad máxima por defecto.
	Maquina maquina = new Maquina("Negra", "Cerveza artesanal", 0.10);

	// Se carga cerveza en la máquina.
	maquina.recargarCerveza(500);

	// Se sirve una cantidad menor a la disponible.
	double valor = maquina.servirCerveza(250);

	// Valida que el valor a pagar se calcule correctamente.
	assertEquals(25.0, valor, TOLERANCIA);

	// Valida que la cantidad servida se descuente correctamente.
	assertEquals(250.0, maquina.getCantidadActual(), TOLERANCIA);
}

}