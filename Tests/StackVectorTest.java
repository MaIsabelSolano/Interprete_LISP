import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;    
    
public class StackVectorTest {

    @Test
    public void testPop() {
        //Se instancia la clase y se une un elemento al vector
        StackVector<String> vec = new StackVector<String>();
        vec.Push("Aprobado");
        
        //Valor esperado
        String resultado = vec.Pop();

        assertEquals("Aprobado", resultado);
    }

    @Test
    public void testEmpty() {
        //Se instancia la clase y se une un elemento al vector
        StackVector<String> vec = new StackVector<String>();
        vec.Push("Aprobado");
        
        //Valor esperado
        Boolean verifier = vec.Empty();

        assertEquals(false, verifier);
    }

    @Test
    public void testPeek() {
        //Se instancia la clase y se une un elemento al vector
        StackVector<String> vec = new StackVector<String>();
        vec.Push("Aprobado");
        
        //Valor esperado
        String resultado = vec.Peek();

        assertEquals("Aprobado", resultado);
    }

    @Test
    public void testSize() {
        //Se instancia la clase y se une un elemento al vector
        StackVector<String> vec = new StackVector<String>();
        vec.Push("Aprobado");
        
        //Valor esperado
        int resultado = vec.Size();

        assertEquals(1, resultado);
    }
}
    