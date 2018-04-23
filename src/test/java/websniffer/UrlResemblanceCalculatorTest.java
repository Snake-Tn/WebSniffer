package websniffer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UrlResemblanceCalculatorTest {

    private UrlResemblanceCalculator calculator;

    @BeforeEach
    void init() {
        calculator = new UrlResemblanceCalculator();
    }

    @Test
    void test_calculate() {
        Assertions.assertEquals(calculator.calculate("abc", "abc"), new Integer(100));
    }
}
