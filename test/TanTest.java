import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import trigonometry.*;


public class TanTest {

    private final double delta = 0.0001;

    private static Sin sin;
    private static Cos cos;
    private static Tan tan;

    @BeforeAll
    static void init() {
        sin = Mockers.mockSin();
        cos = Mockers.mockCos();
        tan = new Tan(sin, cos);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 6, Math.PI / 4, 1, -Math.PI / 3, -1,
            2 * Math.PI / 3, -4 * Math.PI / 3, Math.PI, -Math.PI / 1.7, Math.PI / 1.9, Double.NaN})
    void tanTest(double x) {
        System.out.println(x);
        Assertions.assertEquals(Math.tan(x), tan.apply(x), delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Math.PI / 2, -3 * Math.PI / 2})
    void tanNotDefinedTest(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> tan.apply(x));
    }
}
