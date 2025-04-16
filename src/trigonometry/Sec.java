package trigonometry;

import java.util.function.Function;

public class Sec implements Function<Double, Double> {
    private final Cos cos;

    public Sec(Cos cos) {
        this.cos = cos;
    }

    @Override
    public Double apply(Double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function sec(x) is not defined at the infinity");

        if (((x - Math.PI / 2) / Math.PI) % 1 == 0) {
            throw new IllegalArgumentException("Function sec(x) is not defined at " + x);
        }

        return 1 / cos.apply(x);
    }

}
