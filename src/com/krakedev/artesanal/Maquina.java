package com.krakedev.artesanal;

public class Maquina {

	private String nombreCerveza;
	private String descripcion;
	private double precioMl;
	private double capacidadMaxima;
	private double cantidadActual;

	public Maquina(String nombreCerveza, String descripcion, double precioMl, double capacidadMaxima) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioMl = precioMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
	}

	public Maquina(String nombreCerveza, String descripcion, double precioMl) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioMl = precioMl;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioMl() {
		return precioMl;
	}

	public void setPrecioMl(double precioMl) {
		this.precioMl = precioMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void imprimir() {
		String mensaje;
		mensaje = "Nombre cerveza: " + nombreCerveza + ", Descripcion: " + descripcion + ", Precio por Ml: " + precioMl
				+ ", Capacidad maxima: " + capacidadMaxima + ", Cantidad Actual: " + cantidadActual;
		System.out.println(mensaje);

	}

	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima - 100;
	}

	public boolean recargarCerveza(double cantidad) {
		double limitePermitido = capacidadMaxima - 100;

		if (cantidadActual + cantidad <= limitePermitido) {

			cantidadActual = cantidadActual + cantidad;
			return true;
		}else {
			return false;
		}
	}
	
	public double servirCerveza(double cantidad) {
		
		if (cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad;
			
			double valor;
			valor = cantidad * precioMl;
			return valor;
		}else {
			return 0;
		}
	}

}
