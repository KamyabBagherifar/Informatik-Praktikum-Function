package currying;
import static currying.Functions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.jqwik.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class JUnitTest {
    @ParameterizedTest
    @CsvSource({"1, 1","8, 21","28, 317811","6, 8","15, 610"})
    void fib_test( int n, int res) {
        assertEquals(res, (int) fib.apply(n));
    }

    @ParameterizedTest
    @CsvSource({"0, 1, 1", "12, 6, 6", "2, 2, 2", "12, 4, 4", "8, 6, 2"})
    void ggt_test( int a, int b, int res) {
        assertEquals(res, (int) ggt.apply(a).apply(b));
    }

    @ParameterizedTest
    @CsvSource({"12, 6, 924", "4, 3, 4", "2, 1, 2", "2, 2, 1", "12, 4, 495"})
    void binom_test( int a, int b, int res) {
        assertEquals(res, (int) binom.apply(a).apply(b));
    }

    @ParameterizedTest
    @CsvSource({"0, 1","0, 1", "6, 720", "7, 5040"})
    void fact_test( int a, int res) {
        assertEquals(res, (int) fact.apply(a));
    }




}
