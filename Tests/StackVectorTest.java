import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackVectorTest {

    @Test
    void set() {
        StackVector<String> sv = new StackVector<>();
        sv.Push("prueba");
        sv.Set(0,"wowo");
        System.out.println(sv.Peek());
        assertEquals("wowo",sv.Peek());
    }
}