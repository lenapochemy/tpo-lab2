import logarithmic.Ln;
import logarithmic.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LogTest {

    private static final double delta = 0.0001;

    private static Ln ln;
    private static Log log10;
    private static Log log2;
    private static Log log3;

    @BeforeAll
    static void init() {
        ln = Mockers.mockLn();
        log10 = new Log(ln, 10);
        log2 = new Log(ln, 2);
        log3 = new Log(ln, 3);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.04, 0.5, 1, 2, 4.5, 30.0 / 4, 20, 3 * Math.PI / 4, Double.NaN})
    void logTest(double x) {
        Assertions.assertEquals(Math.log10(x), log10.apply(x), delta);
        Assertions.assertEquals(Math.log(x) / Math.log(2), log2.apply(x), delta);
        Assertions.assertEquals(Math.log(x) / Math.log(3), log3.apply(x), delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0, -3, -1.4})
    void logNotDefinedTest(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> log10.apply(x));
        Assertions.assertThrows(IllegalArgumentException.class, () -> log2.apply(x));
        Assertions.assertThrows(IllegalArgumentException.class, () -> log3.apply(x));
    }


}
