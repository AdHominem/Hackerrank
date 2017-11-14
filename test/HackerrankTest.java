import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HackerrankTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    private static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    private static void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    void testPrintFormatted() {
        JavaCurrencyFormatter.printFormatted(12324.134);
        assertEquals("US: $12,324.13\n" +
                "India: Rs.12,324.13\n" +
                "China: ￥12,324.13\n" +
                "France: 12 324,13 €", outContent.toString());
    }

    @Test
    void testGetDay() {
        assertEquals("WEDNESDAY", JavaDateAndTime.getDay("05", "08", "2015"));
    }

    @Test
    void testExtractLegalTagContent() {
        assertEquals("Sanjay has no watch\nSo wait for a while",
                TagContentExtractor.extract(
                        "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>"
                )
        );
    }

    @Test
    void testExtractIllegalTagContent() {
        assertEquals("None",
                TagContentExtractor.extract(
                        "<Amee>safat codes like a ninja</amee>"
                )
        );
    }

    @Test
    void testExtractIllegalTagContentInheritance() {
        assertEquals("None",
                TagContentExtractor.extract(
                        "<legal><a>Nice!</a>Illegal</legal>"
                )
        );
    }

}