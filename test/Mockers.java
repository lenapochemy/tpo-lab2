import logarithmic.Ln;
import logarithmic.Log;
import trigonometry.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Mockers {

    private Mockers() {
    }

    private final static double[] argsForFunc = {-1, -0.8, -0.7, -2, -1.3, 2, 0.3, 1.1, 1.5,
            2.1, 0.7, 0.5, 4, 0.811673, 0.6, 1.3, -2.4, -2.5, -2.47, -2.54, -0.73,
            -1 - 2 * Math.PI, -0.8 - 2 * Math.PI, -0.7 - 2 * Math.PI, -2 - 2 * Math.PI, -1.3 - 2 * Math.PI, 2 - 2 * Math.PI, 0.3 - 2 * Math.PI, 1.1 - 2 * Math.PI, 1.5 - 2 * Math.PI,
            2.1 - 2 * Math.PI, 0.7 - 2 * Math.PI, 0.5 - 2 * Math.PI, 4 - 2 * Math.PI, 0.811673 - 2 * Math.PI, 0.6 - 2 * Math.PI, 1.3 - 2 * Math.PI, -2.4 - 2 * Math.PI, -2.5 - 2 * Math.PI, -2.47 - 2 * Math.PI, -2.54 - 2 * Math.PI, -0.73 - 2 * Math.PI};
    private final static double[] argsForLogFunc = {2, 0.3, 1.1, 1.5, 2.1, 0.7, 0.5, 4, 0.811673, 0.6, 1.3,};

    public static Sin mockSin() {
        Sin sin = mock();

        double[] args = {0, Math.PI / 6, Math.PI / 4, 1, -Math.PI / 3, -1,
                2 * Math.PI / 3, -4 * Math.PI / 3, Math.PI,
                -Math.PI / 1.7, Math.PI / 1.9, -3, Math.PI / 2, 0.12, -Math.PI / 30, Double.NaN,};
        double[] values = {0, 0.5, 0.70710678, 0.84147098, -0.8660254, -0.84147098,
                0.8660254, 0.8660254, 0, -0.96182564, 0.99658449, -0.14112001, 1, 0.11971221, -0.10452846,
                Double.NaN};

        for (int i = 0; i < args.length; i++) {
            when(sin.apply(args[i])).thenReturn(values[i]);
        }

        double[] valForFunc = {-0.84147098, -0.71735609, -0.64421769, -0.90929743, -0.96355819, 0.90929743,
                0.29552021, 0.89120736, 0.99749499, 0.86320937, 0.64421769, 0.47942554, -0.7568025,
                0.72543969, 0.56464247, 0.96355819, -0.67546318, -0.59847214, -0.62223356, -0.56595623, -0.66686964,
                -0.84147098, -0.71735609, -0.64421769, -0.90929743, -0.96355819, 0.90929743,
                0.29552021, 0.89120736, 0.99749499, 0.86320937, 0.64421769, 0.47942554, -0.7568025,
                0.72543969, 0.56464247, 0.96355819, -0.67546318, -0.59847214, -0.62223356, -0.56595623, -0.66686964
        };

        for (int i = 0; i < argsForFunc.length; i++) {
            when(sin.apply(argsForFunc[i])).thenReturn(valForFunc[i]);
        }

        return sin;
    }


    public static Cos mockCos() {
        Cos cos = mock();

        double[] args = {-3 * Math.PI / 2, 0, Math.PI / 6, Math.PI / 4, 1, -Math.PI / 3, -1,
                2 * Math.PI / 3, -4 * Math.PI / 3, Math.PI, -Math.PI / 1.7, Math.PI / 1.9, Math.PI / 2,
                0.12, -Math.PI / 30, Double.NaN};
        double[] values = {0, 1, 0.8660254, 0.70710678, 0.54030231, 0.5, 0.54030231,
                -0.5, -0.5, -1, -0.27366299, -0.082579345, 0, 0.99280864, 0.9945219, Double.NaN};

        for (int i = 0; i < args.length; i++) {
            when(cos.apply(args[i])).thenReturn(values[i]);
        }

        double[] valForFunc = {0.54030231, 0.69670671, 0.76484219, -0.41614684, 0.26749883, -0.41614684,
                0.95533649, 0.45359612, 0.070737202, -0.5048461, 0.76484219, 0.87758256, -0.65364362,
                0.68828574, 0.82533561, 0.26749883, -0.73739372, -0.80114362, -0.78283166, -0.82443529, 0.7451744,
                0.54030231, 0.69670671, 0.76484219, -0.41614684, 0.26749883, -0.41614684,
                0.95533649, 0.45359612, 0.070737202, -0.5048461, 0.76484219, 0.87758256, -0.65364362,
                0.68828574, 0.82533561, 0.26749883, -0.73739372, -0.80114362, -0.78283166, -0.82443529, 0.7451744
        };

        for (int i = 0; i < argsForFunc.length; i++) {
            when(cos.apply(argsForFunc[i])).thenReturn(valForFunc[i]);
        }

        return cos;
    }

    public static Sec mockSec() {
        Sec sec = mock();

        double[] valForFunc = {
                1.8508157, 1.4353242, 1.3074593, -2.402998, 3.7383341, -2.402998,
                1.0467516, 2.2046044, 14.136833, -1.9808017, 1.3074593, 1.1394939, -1.5298857,
                1.452885, 1.2116283, 3.7383341, -1.3561276, -1.2482157, -1.2774138, -1.2129515, 1.3419677,
                1.8508157, 1.4353242, 1.3074593, -2.402998, 3.7383341, -2.402998,
                1.0467516, 2.2046044, 14.136833, -1.9808017, 1.3074593, 1.1394939, -1.5298857,
                1.452885, 1.2116283, 3.7383341, -1.3561276, -1.2482157, -1.2774138, -1.2129515, 1.3419677
        };

        for (int i = 0; i < argsForFunc.length; i++) {
            when(sec.apply(argsForFunc[i])).thenReturn(valForFunc[i]);
        }

        return sec;
    }

    public static Csc mocCsc() {
        Csc csc = mock();

        double[] valForFunc = {
                -1.1883951, -1.3940078, -1.5522703, -1.0997502, -1.03782, 1.0997502,
                3.3838634, 1.1220733, 1.0025113, 1.1584675, 1.5522703, 2.0858296, -1.3213487,
                1.3784743, 1.7710322, 1.03782, -1.4804656, -1.6709215, -1.6071136, -1.7669211, -1.4995435,
                -1.1883951, -1.3940078, -1.5522703, -1.0997502, -1.03782, 1.0997502,
                3.3838634, 1.1220733, 1.0025113, 1.1584675, 1.5522703, 2.0858296, -1.3213487,
                1.3784743, 1.7710322, 1.03782, -1.4804656, -1.6709215, -1.6071136, -1.7669211, -1.4995435

        };

        for (int i = 0; i < argsForFunc.length; i++) {
            when(csc.apply(argsForFunc[i])).thenReturn(valForFunc[i]);
        }

        return csc;
    }

    public static Tan mocTan() {
        Tan tan = mock();

        double[] valForFunc = {
                -1.5574077, -1.0296386, -0.84228838, 2.1850399, -3.6021024, -2.1850399,
                0.30933625, 1.9647597, 14.10142, -1.7098465, 0.84228838, 0.54630249, 1.1578213,
                1.0539804, 0.68413681, 3.6021024, 0.91601429, 0.7470223, 0.79484976, 0.68647744, -0.89491753,
                -1.5574077, -1.0296386, -0.84228838, 2.1850399, -3.6021024, -2.1850399,
                0.30933625, 1.9647597, 14.10142, -1.7098465, 0.84228838, 0.54630249, 1.1578213,
                1.0539804, 0.68413681, 3.6021024, 0.91601429, 0.7470223, 0.79484976, 0.68647744, -0.89491753
        };

        for (int i = 0; i < argsForFunc.length; i++) {
            when(tan.apply(argsForFunc[i])).thenReturn(valForFunc[i]);
        }

        return tan;
    }

    public static Cot mocCot() {
        Cot cot = mock();

        double[] valForFunc = {
                -0.64209262, -0.9712146, -1.1872418, 0.45765755, -0.27761565, -0.45765755, 3.2327281,
                0.50896811, 0.070914844, -0.58484781, 1.1872418, 1.8304877, 0.86369115,
                0.94878423, 1.4616959, 0.27761565, 1.091686, 1.3386481, 1.2580994, 1.4567121, -1.1174214,
                -0.64209262, -0.9712146, -1.1872418, 0.45765755, -0.27761565, -0.45765755, 3.2327281,
                0.50896811, 0.070914844, -0.58484781, 1.1872418, 1.8304877, 0.86369115,
                0.94878423, 1.4616959, 0.27761565, 1.091686, 1.3386481, 1.2580994, 1.4567121, -1.1174214
        };

        for (int i = 0; i < argsForFunc.length; i++) {
            when(cot.apply(argsForFunc[i])).thenReturn(valForFunc[i]);
        }

        return cot;
    }

    public static Ln mockLn() {
        Ln ln = mock();

        double[] args = {0.04, 0.5, 1, 2, 20, 4.5, 3 * Math.PI / 4, 30.0 / 4, 3, 10, Double.NaN};
        double[] values = {-3.2188758, -0.69314718, 0, 0.69314718, 2.9957323, 1.5040774,
                0.85704781, 2.014903, 1.0986123, 2.3025851, Double.NaN};

        for (int i = 0; i < args.length; i++) {
            when(ln.apply(args[i])).thenReturn(values[i]);
        }

        double[] valForFunc = {0.69314718, -1.2039728, 0.09531018, 0.40546511, 0.74193734, -0.35667494, -0.69314718, 1.3862944,
                -0.20865773, -0.51082562, 0.26236426
        };

        for (int i = 0; i < argsForLogFunc.length; i++) {
            when(ln.apply(argsForLogFunc[i])).thenReturn(valForFunc[i]);
        }

        return ln;
    }

    public static Log mockLog10() {
        Log log10 = mock();

        double[] valForFunc = {
                0.30103, -0.52287875, 0.041392685, 0.17609126, 0.32221929, -0.15490196, -0.30103, 0.60205999,
                -0.0906189, -0.22184875, 0.11394335
        };
        for (int i = 0; i < argsForLogFunc.length; i++) {
            when(log10.apply(argsForLogFunc[i])).thenReturn(valForFunc[i]);
        }

        return log10;
    }

    public static Log mockLog2() {
        Log log2 = mock();

        double[] valForFunc = {
                1, -1.7369656, 0.13750352, 0.5849625, 1.0703893, -0.51457317, -1, 2,
                -0.30102947, -0.73696559, 0.37851162
        };
        for (int i = 0; i < argsForLogFunc.length; i++) {
            when(log2.apply(argsForLogFunc[i])).thenReturn(valForFunc[i]);
        }

        return log2;
    }

    public static Log mockLog3() {
        Log log3 = mock();

        double[] valForFunc = {
                0.63092975, -1.0959033, 0.086755064, 0.36907025, 0.67534047, -0.32465953, -0.63092975, 1.2618595,
                -0.18992845, -0.46497352, 0.23881425
        };
        for (int i = 0; i < argsForLogFunc.length; i++) {
            when(log3.apply(argsForLogFunc[i])).thenReturn(valForFunc[i]);
        }

        return log3;
    }


}
