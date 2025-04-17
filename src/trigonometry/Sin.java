package trigonometry;

import java.util.function.Function;

public class Sin implements Function<Double, Double> {

    private final double delta;

    public Sin(double delta) {
        this.delta = delta;
    }

    @Override
    public Double apply(Double x) {

        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY)
            throw new IllegalArgumentException("Function sin(x) is not defined at the infinity");
        x = x % (2 * Math.PI);

        double sum = 0;
        double tmp = 1;
        int n = 0;
        while (Math.abs(tmp) > delta) {
            tmp = Math.pow(-1, n) * Math.pow(x, (2 * n + 1)) / factorial(2 * n + 1);
            sum += tmp;
            n++;
        }
        return sum;
    }

    public int factorial(int n) {
        int acc = 1;
        for (int i = 1; i <= n; i++) {
            acc *= i;
        }
        return acc;
    }
}
