import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import trigonometry.Csc;
import trigonometry.Sin;


public class CscTest {

    private final double delta = 0.0001;

    private static Sin sin;
    private static Csc csc;

    @BeforeAll
    static void init() {
        sin = Mockers.mockSin();
        csc = new Csc(sin);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 2, Math.PI / 6, Math.PI / 4, 1, -Math.PI / 3,
            2 * Math.PI / 3, -4 * Math.PI / 3, -Math.PI / 1.7, 0.12, -Math.PI / 30, Double.NaN})
    void cscTest(double x) {
        System.out.println(x);
        Assertions.assertEquals(1 / Math.sin(x), csc.apply(x), delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0, 5 * Math.PI, -2 * Math.PI})
    void cscNotDefinedTest(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> csc.apply(x));
    }
}
