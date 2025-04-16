import logarithmic.Ln;
import logarithmic.Log;
import trigonometry.*;

import java.util.function.Function;

public class BigFunction implements Function<Double, Double> {

    private final Sin sin;
    private final Cos cos;
    private final Csc csc;
    private final Sec sec;
    private final Tan tan;
    private final Cot cot;
    private final Ln ln;
    private final Log log2;
    private final Log log3;
    private final Log log10;

    public BigFunction(Sin sin, Cos cos, Csc csc, Sec sec, Tan tan, Cot cot, Ln ln, Log log2, Log log3, Log log10) {
        this.sin = sin;
        this.cos = cos;
        this.csc = csc;
        this.sec = sec;
        this.tan = tan;
        this.cot = cot;
        this.ln = ln;
        this.log10 = log10;
        this.log2 = log2;
        this.log3 = log3;
    }

    @Override
    public Double apply(Double x) {
        if (x <= 0) {
            double sinx = sin.apply(x);
            double cosx = cos.apply(x);
            double secx = sec.apply(x);
            double cscx = csc.apply(x);
            double tanx = tan.apply(x);
            double cotx = cot.apply(x);

            System.out.println(sinx + " " + cosx + " " + secx + " " + cscx + " " + tanx + " " + cotx);

            double a = Math.pow(((((Math.pow(sinx * cosx, 3) / cosx) + cotx - sinx) / tanx) + secx), 3) * cscx * cscx;
            double b = Math.pow(((((secx - (cscx * secx)) - Math.pow((Math.pow(secx, 3) / secx), 3)) + sinx) * Math.pow(tanx, 2)), 2);
            double c = Math.pow(Math.pow(cscx, 3), 2) * sinx / (cotx + Math.pow(cscx, 3));
            return a / (b / c);

//            return (((((Math.pow((((((Math.pow(sinx * cosx, 3) / cosx) + cotx) - sinx) / tanx) + secx), 3) * cscx) * cscx) / (Math.pow(((((secx - (cscx * secx)) - Math.pow((Math.pow(secx, 3) / secx), 3)) + sinx) * Math.pow(tanx, 2)), 2) / ((Math.pow(Math.pow(cscx, 3), 2) * sinx) / (cotx + Math.pow(cscx, 3)))))));

        } else {
            double lnx = ln.apply(x);
            double log10x = log10.apply(x);
            double log2x = log2.apply(x);
            double log3x = log3.apply(x);

            double a = (Math.pow(log10x, 2) / log10x) + Math.pow(log2x, 2);
            double b = lnx / (log3x * lnx);
            return Math.pow(a * b, 3);
        }

    }


}
