import logarithmic.Ln;
import logarithmic.Log;
import trigonometry.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final double delta = 0.0001;

        Sin sin = new Sin(delta);
        Cos cos = new Cos(sin);
        Sec sec = new Sec(cos);
        Csc csc = new Csc(sin);
        Tan tan = new Tan(sin, cos);
        Cot cot = new Cot(sin, cos);
        Ln ln = new Ln(delta / 100);
        Log log2 = new Log(ln, 2);
        Log log3 = new Log(ln, 3);
        Log log10 = new Log(ln, 10);

        BigFunction function = new BigFunction(sin, cos, csc, sec, tan, cot, ln, log2, log3, log10);
        CsvPrinter csvPrinter = new CsvPrinter();

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        csvPrinter.calcAndPrint(function, 3.3, 3.8, 0.01, buf);

        try (FileOutputStream fileOutputStream = new FileOutputStream("res.csv")){
            buf.writeTo(fileOutputStream);
        } catch (IOException e){
            System.out.println("problem with writing to file");
        }


    }
}
