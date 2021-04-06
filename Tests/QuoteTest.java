import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuoteTest {

    @Test
    void devolverQuote() {
        Quote quote = new Quote();
        String prueba = quote.DevolverQuote("hola");
        assertEquals("hola",prueba);
    }
}