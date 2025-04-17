import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trigonometry.Csc;
import trigonometry.Sin;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CsvPrinterTest {

    private CsvPrinter csvPrinter;
    private Sin sin;
    private Csc csc;
    private ByteArrayOutputStream buf;

    @BeforeEach
    public void init(){
        csvPrinter = new CsvPrinter();
        sin = new Sin(0.0001);
        csc = new Csc(sin);
        buf = new ByteArrayOutputStream();
    }


    @Test
    public void sinCsvPrinterTest() {
        csvPrinter.calcAndPrint(sin, 0.0, 1.0, 0.5, buf);
        assertEquals("0,000000;0,000000\n" +
                "0,500000;0,479426\n" +
                "1,000000;0,841471\n", buf.toString());
    }


    @Test
    void funcNotDefinedTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> csvPrinter.calcAndPrint(sin, 2.0, 1.0, 0.1, buf) );
        Assertions.assertThrows(IllegalArgumentException.class, () -> csvPrinter.calcAndPrint(sin, 0.0, 1.0, 0.0, buf) );
        Assertions.assertThrows(IllegalArgumentException.class, () -> csvPrinter.calcAndPrint(csc, 2 * Math.PI, 3 * Math.PI, 0.0, buf) );
    }
}
