import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import trigonometry.Cos;
import trigonometry.Sec;


public class SecTest {

    private final double delta = 0.0001;

    private static Cos cos;
    private static Sec sec;

    @BeforeAll
    static void init() {
        cos = Mockers.mockCos();
        sec = new Sec(cos);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 6, Math.PI / 4, 1, -Math.PI / 3, -1,
            2 * Math.PI / 3, -4 * Math.PI / 3, Math.PI, -Math.PI / 1.7, Math.PI / 1.9, Double.NaN})
    void secTest(double x) {
        System.out.println(x);
        Assertions.assertEquals(1 / Math.cos(x), sec.apply(x), delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Math.PI / 2, -3 * Math.PI / 2})
    void secNotDefinedTest(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> sec.apply(x));
    }
}
