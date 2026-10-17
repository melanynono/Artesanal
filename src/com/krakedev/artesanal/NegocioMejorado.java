package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	ArrayList<Maquina> maquinas;
	
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
	
	public void agregarMaquina (String nombreCerveza, String descripcion, double precioMl) {
		
		String codigo = generarCodigo();
		Maquina maquina = new Maquina(nombreCerveza, descripcion, precioMl, codigo );
		
		maquinas.add(maquina);
	}
	

public Maquina recuperarMaquina(String codigo) {

    for (Maquina maquina : maquinas) {

        if (maquina.getCodigo().equals(codigo)) {
            return maquina;
        }
    }

    return null;
}

	

}
