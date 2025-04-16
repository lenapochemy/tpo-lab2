package logarithmic;

import java.util.function.Function;

public class Ln implements Function<Double, Double> {

    private final double delta;

    public Ln(double delta) {
        this.delta = delta;
    }

    @Override
    public Double apply(Double x) {

        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function ln(x) is not defined at the infinity");

        if (x <= 0) {
            throw new IllegalArgumentException("Function ln(x) is not defined at the negative");
        }

        double sum = 0;
        double tmp = 1;
        int n = 0;
        while (Math.abs(tmp) > delta) {
            tmp = Math.pow((x - 1) / (x + 1), 2 * n + 1) / (2 * n + 1);
            if (tmp == Double.NEGATIVE_INFINITY || tmp == Double.POSITIVE_INFINITY) {
                break;
            }
            sum += tmp;
            n++;
        }
        System.out.println();
        return 2 * sum;
    }
}
