import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;    
    
public class ArithmeticTest {
        
    @Test
    public void testCalculogood() {

        // Instanciar la clase
        Arithmetic arit = new Arithmetic();

        // Expresion a evaluar
        String expresion = "5 2 3 + *";

        // Valor esperado
        String valorEsperado = "25.0";

        // ejecutar metodo
        String resultado = arit.Calculo(expresion);

        // Prueba
        assertEquals(valorEsperado, resultado);
    }
    
    @Test
    public void testCalculoBad(){

        // Test para comprobar la primera falla en al calculadora

        // Instanciar la clase
        Arithmetic arit = new Arithmetic();

        // Expresion a evaluar
        String expresion = "5 2 3 4 4 5 5 6 6 + *";

        // Valor esperado
        String valorEsperado = "No se puede operar, hay demasiados numeros";

        // ejecutar metodo
        String resultado = arit.Calculo(expresion);

        // Prueba
        assertEquals(valorEsperado, resultado);
    }

    @Test
    public void testCalculoBadtwo(){

        // Test para comprobar la segunda falla en al calculadora
        
        // Instanciar la clase
        Arithmetic arit = new Arithmetic();

        // Expresion a evaluar
        String expresion = "5 2 3  + * * + / /";

        // Valor esperado
        String valorEsperado = "No se puede operar, hay un error de signos";

        // ejecutar metodo
        String resultado = arit.Calculo(expresion);

        // Prueba
        assertEquals(valorEsperado, resultado);
    }
}
