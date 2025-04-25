import logarithmic.Ln;
import logarithmic.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import trigonometry.*;

import java.util.stream.Stream;

public class FunctionTest {

    private static final double delta = 0.0001;

    private static BigFunction function;
    private static Sin sin;
    private static Cos cos;
    private static Csc csc;
    private static Sec sec;
    private static Tan tan;
    private static Cot cot;
    private static Ln ln;
    private static Log log2;
    private static Log log3;
    private static Log log10;


    @BeforeAll
    static void init() {
        sin = new Sin(delta);
        cos = new Cos(sin);
        sec = new Sec(cos);
        csc = new Csc(sin);
        tan = new Tan(sin, cos);
        cot = new Cot(sin, cos);
        ln = new Ln(delta / 100);
        log2 = new Log(ln, 2);
        log3 = new Log(ln, 3);
        log10 = new Log(ln, 10);

        function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);
    }

    @ParameterizedTest
    @MethodSource("FunctionIntegrationTest#provideFunctionModuleTest")
    void functionTest(double x, double res) {
        Assertions.assertEquals(res, function.apply(x), delta);
    }


}
