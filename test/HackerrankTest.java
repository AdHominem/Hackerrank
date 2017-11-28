import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void testJavaExceptionHandllingZero() {
        Exception exception = assertThrows(Exception.class, () -> JavaExceptionHandling.power(0, 0));
        assertEquals(exception.getMessage(), "n and p should not be zero.");
    }

    @Test
    void testJavaExceptionHandllingNeg1() {
        Exception exception = assertThrows(Exception.class, () -> JavaExceptionHandling.power(-1, 1));
        assertEquals(exception.getMessage(), "n or p should not be negative.");
    }

    @Test
    void testJavaExceptionHandllingNeg2() {
        Exception exception = assertThrows(Exception.class, () -> JavaExceptionHandling.power(1, -1));
        assertEquals(exception.getMessage(), "n or p should not be negative.");
    }

    @Test
    void testJavaExceptionHandlling() throws Exception {
        assertEquals(32, JavaExceptionHandling.power(2, 5));
    }

    @Test
    void testJavaIterator() {
        List list = Arrays.asList(42, 10, "###", "Hello", "Java");
        Iterator it = JavaIterator.func(list);
        while(it.hasNext()){
            Object element = it.next();
            System.out.println((String) element);
        }
        assertEquals("Hello\nJava\n", outContent.toString());
    }

}