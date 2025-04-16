package logarithmic;

import java.util.function.Function;

public class Log implements Function<Double, Double> {

    private final Ln ln;
    private final double lnBase;

    public Log(Ln ln, double base) {
        this.ln = ln;
        lnBase = ln.apply(base);
    }

    @Override
    public Double apply(Double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function log(x) is not defined at the infinity");

        if (x <= 0) {
            throw new IllegalArgumentException("Function log(x) is not defined at the negative");
        }

        return ln.apply(x) / lnBase;
    }
}
