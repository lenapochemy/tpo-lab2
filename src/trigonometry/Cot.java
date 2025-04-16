package trigonometry;

import java.util.function.Function;

public class Cot implements Function<Double, Double> {

    private final Sin sin;
    private final Cos cos;

    public Cot(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }
    @Override
    public Double apply(Double x) {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function cot(x) is not defined at the infinity");

        if ((x / Math.PI) % 1 == 0) {
            throw new IllegalArgumentException("Function cot(x) is not defined at " + x);
        }

        return cos.apply(x) / sin.apply(x);
    }
}
