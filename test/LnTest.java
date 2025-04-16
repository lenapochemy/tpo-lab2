import logarithmic.Ln;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LnTest {

    private static final double delta = 0.0001;

    private static Ln ln;

    @BeforeAll
    static void init() {
        ln = new Ln(delta / 100);
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.04, 0.5, 1, 2, 4.5, 30 / 4, 20, 3 * Math.PI / 4, Double.NaN})
    void lnTest(double x) {
        Assertions.assertEquals(Math.log(x), ln.apply(x), delta);
    }


    @ParameterizedTest
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0, -3, -1.4})
    void lnNotDefinedTest(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ln.apply(x));
    }


}
