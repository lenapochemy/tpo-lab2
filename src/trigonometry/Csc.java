package trigonometry;

import java.util.function.Function;

public class Csc implements Function<Double, Double> {

    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    @Override
    public Double apply(Double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function csc(x) is not defined at the infinity");

        if ((x / Math.PI) % 1 == 0) {
            throw new IllegalArgumentException("Function csc(x) is not defined at " + x);
        }

        return 1 / sin.apply(x);
    }
}
