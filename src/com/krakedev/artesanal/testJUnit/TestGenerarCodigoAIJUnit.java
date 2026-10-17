package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigoAIJUnit {


    @Test
    public void testGenerarCodigo() {
        NegocioMejorado negocio = new NegocioMejorado();

        String codigo = negocio.generarCodigo();

        // Verificar que el código no sea null
        assertNotNull(codigo);

        // Verificar que comience con M-
        assertTrue(codigo.startsWith("M-"));

        // Extraer el número del código
        int numero = Integer.parseInt(codigo.substring(2));

        // Verificar que esté entre 1 y 100
        assertTrue(numero >= 1 && numero <= 100);
    }
    

    @Test
    public void testFormatoCodigo() {
    NegocioMejorado negocio = new NegocioMejorado();

    String codigo = negocio.generarCodigo();

    assertTrue(codigo.matches("M-(100|[1-9][0-9]?)"));
}

}

	

