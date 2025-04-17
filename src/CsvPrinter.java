import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.function.Function;

public class CsvPrinter {

    public void calcAndPrint(Function<Double, Double> func, Double start, Double end, Double step, OutputStream out) {
        if (start > end) {
            throw new IllegalArgumentException("Start can't be greater than end");
        }
        if (step == 0) {
            throw new IllegalArgumentException("Step can't be 0");
        }

        PrintWriter printWriter = new PrintWriter(out);
        for (Double x = start; x <= end; x += step) {
                Double res = func.apply(x);
                if(!Double.isNaN(res) && res <= 100.0) {
                    printWriter.printf("%f;%f\n", x, res);
                }

        }

        printWriter.flush();

    }
}
