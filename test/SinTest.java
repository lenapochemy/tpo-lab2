import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import trigonometry.Sin;

public class SinTest {

    private static final double delta = 0.0001;

    private static Sin sin;

    @BeforeAll
    static void init() {
        sin = new Sin(delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI / 6, 1, -Math.PI / 3, -1, 2 * Math.PI / 3,
            -Math.PI / 1.7, Math.PI / 1.9, Double.NaN})
    void sinTest(double x) {
        Assertions.assertEquals(Math.sin(x), sin.apply(x), delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void sinInfinityTest(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> sin.apply(x));
    }

    @Test
    void factorialTest() {
        Assertions.assertEquals(1, sin.factorial(1));
        Assertions.assertEquals(1, sin.factorial(0));
        Assertions.assertEquals(6, sin.factorial(3));
    }


}
