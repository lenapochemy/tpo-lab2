import org.junit.jupiter.api.Test;
import trigonometry.Sin;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvPrinterTest {


    @Test
    public void sinCsvPrinterTest() {
        Sin sin = new Sin(0.0001);
        CsvPrinter csvPrinter = new CsvPrinter();

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        csvPrinter.calcAndPrint(sin, 0.0, 1.0, 0.5, buf);
        assertEquals("0,000000;0,000000\n" +
                "0,500000;0,479426\n" +
                "1,000000;0,841471\n", buf.toString());
    }
}
