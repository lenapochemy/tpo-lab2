package trigonometry;

import java.util.function.Function;

public class Cos implements Function<Double, Double> {
    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }
    @Override
    public Double apply(Double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function cos(x) is not defined at the infinity");

        x = x % (2 * Math.PI);

        double sinx = sin.apply(x);
        double res = Math.sqrt(1 - Math.pow(sinx, 2));
        if (-3 * Math.PI / 2 < x && x < -Math.PI / 2 || Math.PI / 2 < x && x < 3 * Math.PI / 2) {
            res *= -1;
        }

        return res;
    }
}
