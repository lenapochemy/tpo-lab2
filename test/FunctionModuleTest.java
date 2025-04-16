import logarithmic.Ln;
import logarithmic.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import trigonometry.*;

import java.util.stream.Stream;

public class FunctionModuleTest {

    private static final double delta = 0.001;

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

    @ParameterizedTest
    @MethodSource("provideFunctionModuleTest")
    void functionModuleTest(double x, double res) {
        sin = Mockers.mockSin();
        cos = Mockers.mockCos();
        sec = Mockers.mockSec();
        csc = Mockers.mocCsc();
        tan = Mockers.mocTan();
        cot = Mockers.mocCot();
        ln = Mockers.mockLn();
        log2 = Mockers.mockLog2();
        log3 = Mockers.mockLog3();
        log10 = Mockers.mockLog10();

        function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);

        Assertions.assertEquals(res, function.apply(x), delta);
    }


    @ParameterizedTest
    @MethodSource("provideFunctionModuleTest")
    void functionSinTest(double x, double res) {
        sin = new Sin(delta);
        cos = Mockers.mockCos();
        sec = Mockers.mockSec();
        csc = Mockers.mocCsc();
        tan = Mockers.mocTan();
        cot = Mockers.mocCot();
        ln = Mockers.mockLn();
        log2 = Mockers.mockLog2();
        log3 = Mockers.mockLog3();
        log10 = Mockers.mockLog10();

        function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);

        Assertions.assertEquals(res, function.apply(x), delta);
    }

    @ParameterizedTest
    @MethodSource("provideFunctionModuleTest")
    void functionSinCosTest(double x, double res) {
        sin = new Sin(delta);
        cos = new Cos(sin);
        sec = Mockers.mockSec();
        csc = Mockers.mocCsc();
        tan = Mockers.mocTan();
        cot = Mockers.mocCot();
        ln = Mockers.mockLn();
        log2 = Mockers.mockLog2();
        log3 = Mockers.mockLog3();
        log10 = Mockers.mockLog10();

        function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);

        Assertions.assertEquals(res, function.apply(x), delta);
    }

    @ParameterizedTest
    @MethodSource("provideFunctionModuleTest")
    void functionTrigModuleTest(double x, double res) {
        sin = new Sin(delta);
        cos = new Cos(sin);
        sec = new Sec(cos);
        csc = new Csc(sin);
        tan = new Tan(sin, cos);
        cot = new Cot(sin, cos);
        ln = Mockers.mockLn();
        log2 = Mockers.mockLog2();
        log3 = Mockers.mockLog3();
        log10 = Mockers.mockLog10();

        function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);

        Assertions.assertEquals(res, function.apply(x), delta);
    }

    @ParameterizedTest
    @MethodSource("provideFunctionModuleTest")
    void functionLnTest(double x, double res) {
        sin = Mockers.mockSin();
        cos = Mockers.mockCos();
        sec = Mockers.mockSec();
        csc = Mockers.mocCsc();
        tan = Mockers.mocTan();
        cot = Mockers.mocCot();
        ln = new Ln(delta);
        log2 = Mockers.mockLog2();
        log3 = Mockers.mockLog3();
        log10 = Mockers.mockLog10();

        function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);

        Assertions.assertEquals(res, function.apply(x), delta);
    }

    @ParameterizedTest
    @MethodSource("provideFunctionModuleTest")
    void functionLnLogTest(double x, double res) {
        sin = Mockers.mockSin();
        cos = Mockers.mockCos();
        sec = Mockers.mockSec();
        csc = Mockers.mocCsc();
        tan = Mockers.mocTan();
        cot = Mockers.mocCot();
        ln = new Ln(delta / 100);
        log2 = new Log(ln, 2);
        log3 = new Log(ln, 3);
        log10 = new Log(ln, 10);

        function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);

        Assertions.assertEquals(res, function.apply(x), delta);
    }

    private static Stream<Arguments> provideFunctionModuleTest() {
        return Stream.of(
                Arguments.of(-1, 0.0011066007),
                Arguments.of(-0.8, 0.43552149),
                Arguments.of(-0.7, 16.135743),
                Arguments.of(-2, -1.539246E-5),
                Arguments.of(-1.3, 3.375467E-8),
                Arguments.of(-2.4, 0.005799676),
                Arguments.of(-0.73, 4.9779805),

                Arguments.of(-1 - 2 * Math.PI, 0.0011066007),
                Arguments.of(-0.8 - 2 * Math.PI, 0.43552149),
                Arguments.of(-0.7 - 2 * Math.PI, 16.135743),
                Arguments.of(-2 - 2 * Math.PI, -1.539246E-5),
                Arguments.of(-1.3 - 2 * Math.PI, 3.375467E-8),
                Arguments.of(-2.4 - 2 * Math.PI, 0.005799676),
                Arguments.of(-0.73 - 2 * Math.PI, 4.9779805),

                Arguments.of(2, 8.7683707),
                Arguments.of(0.3, -11.78859),
                Arguments.of(1.1, 0.33578814),
                Arguments.of(1.5, 2.769154),
                Arguments.of(2.1, 10.269937),
                Arguments.of(0.7, -0.038771631),
                Arguments.of(0.5, -1.3596671),
                Arguments.of(4, 48.509167),
                Arguments.of(0.811673, 5.740946E-19),
                Arguments.of(0.6, -0.32985569),
                Arguments.of(1.3, 1.2494105)
        );
    }


}
