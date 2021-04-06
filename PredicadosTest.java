import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredicadosTest {

    @Test
    void isErr() {
        Predicados P = new Predicados(false);
        boolean output = P.isErr();
        assertEquals(false,output);
    }

    @Test
    void pred() {
        StackVector stackVector = new StackVector();
        stackVector.Push("COND");
        stackVector.Push("<");
        stackVector.Push("5");
        stackVector.Push("10");

        Predicados P = new Predicados(false);
        boolean output = P.Pred(stackVector);
        assertEquals(true,output);
    }
}