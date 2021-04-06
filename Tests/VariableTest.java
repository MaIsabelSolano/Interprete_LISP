import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableTest {

    @Test
    void definirVariable() {
        Variable var = new Variable();
        var.DefinirVariable("llave","valor");
        assertTrue(var.ExisteVariable("llave"));

    }

    @Test
    void existeVariable() {
        Variable var = new Variable();
        var.DefinirVariable("llave","valor");
        assertTrue(var.ExisteVariable("llave"));
    }

    @Test
    void valor() {
        Variable var = new Variable();
        var.DefinirVariable("llave","valor");
        assertEquals("valor", var.Valor("llave"));
    }
}