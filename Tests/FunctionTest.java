import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;    
    
public class FunctionTest {

    @Test
    public void testInsertParameter() {
        
        // En este test se comprobara si el codigo
        // Inserta correctamente el parametro al codigo de la funcion
        
        // Declarar las propiedades de una funcion
        String nombre = "dummyFunction";
        String parametro = "x";
        String codigo = "* x 3";

        // Instanciar la clase
        Function dummyFunction = new Function(nombre, parametro, codigo);

        // Valor esperado
        String valorEsperado = "* 3 3";

        // ejecutar metodo
        String resultado = dummyFunction.insertParameter(3);

        // Prueba
        assertEquals(valorEsperado, resultado);
    }
}