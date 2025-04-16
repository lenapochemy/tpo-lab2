import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import trigonometry.Cos;
import trigonometry.Sin;


public class CosTest {

    private final double delta = 0.0001;
    private static Sin sin;
    private static Cos cos;

    @BeforeAll
    static void init() {
        sin = Mockers.mockSin();
        cos = new Cos(sin);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 6, Math.PI / 4, 1, -Math.PI / 3, -1,
            2 * Math.PI / 3, -4 * Math.PI / 3, Math.PI, Double.NaN})
    void cosTest(double x) {
        Assertions.assertEquals(Math.cos(x), cos.apply(x), delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void cosInfinityTest(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cos.apply(x));
    }
}
