package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private int ultimoCodigo = 100;
	
	public NegocioMejorado() {
		
		maquinas = new ArrayList<Maquina>();
		
	}
	

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public String generarCodigo() {
		
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
		
	}
	
	public boolean agregarMaquina (String nombreCerveza, String descripcion, double precioMl) {
		
		String codigo = generarCodigo();
		Maquina maquina = new Maquina(nombreCerveza, descripcion, precioMl, codigo );
		
		Maquina existente = recuperarMaquina(codigo);
		
		if(existente == null) {
			maquinas.add(maquina);
			
			return true;
		}else {
			return false;
		}
	}
	
	
	public void cargarMaquinas() {
		
		for (Maquina maquina : maquinas) {
			maquina.llenarMaquina();
		}
		
	}
	

    public Maquina recuperarMaquina(String codigo) {

    for (Maquina maquina : maquinas) {

        if (maquina.getCodigo().equals(codigo)) {
            return maquina;
        }
    }

    return null;
    }

	
    public void registrarCliente(String nombre, String cedula) {
    	
    	Cliente cliente = new Cliente(nombre, cedula);
    	
    	cliente.setCodigo(ultimoCodigo);
    	ultimoCodigo++;
    	
    	clientes.add(cliente);
    }

    
    public Cliente buscarClientePorCedula(String cedula) {
    	for(Cliente cliente : clientes ) {
    		
    		if(cliente.getCedula().equals(cedula)) {
    			return cliente;
    			
    		}
    	
    	}
    	return null;
    }
    
    
    public Cliente buscarClientePorCodigo(double codigo) {
    	
    	for (Cliente cliente : clientes) {
    		
    		if(cliente.getCodigo() == (codigo)) {
    			return cliente;
    		}
    	}
    	
    	return null; 	
    }

    
    public void consumirCerveza(double codigoCliente, String codigoMaquina, double cantidad) {
    	
        Maquina maquina = recuperarMaquina(codigoMaquina);
        
        Cliente cliente = buscarClientePorCodigo(codigoCliente);
        
        if(maquina != null && cliente != null) {
        	double valor = maquina.servirCerveza(cantidad);
        	registrarConsumo(codigoCliente, valor);
        	}
    	
    }
    
    public void registrarConsumo(double codigoCliente, double valor) {
    	
    	Cliente cliente = buscarClientePorCodigo(codigoCliente);
    	
    	 if (cliente != null) {
    	        cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
    	    }
    	
    }

    
    public double consultarValorVendido () {
    	double total = 0;
    	
    	for(Cliente cliente : clientes) {
    		
    		total = total + cliente.getTotalConsumido();
    	}
    	return total;
    	
    }
    
}
