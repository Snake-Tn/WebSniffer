package websniffer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UrlResemblanceCalculatorTest {

    @InjectMocks
    private UrlResemblanceCalculator calculator;
    @Mock
    private CommonRateUrlPartCalculator commonRateUrlPartCalculator;
    @Spy
    private RegularExpressionGenerator regularExpressionGenerator;
    @Spy
    private FibonaciiCoefficientGenerator fibonaciiCoefficientGenerator;

    @Test
    public void test_calculate() {
        when(commonRateUrlPartCalculator.calculate(any(String.class))).thenReturn(0f);
        when(commonRateUrlPartCalculator.calculate("product")).thenReturn(1f);
        when(commonRateUrlPartCalculator.calculate("category")).thenReturn(1f);

        Assert.assertEquals(new Float(1), calculator.calculate("abc", "abc"));

        Assert.assertTrue(calculator.calculate(
                "product/beautiful-dress.html",
                "product/big-house.html"
                ) > 0.9
        );
        Assert.assertTrue(calculator.calculate(
                "category/good-days.html",
                "product/big-house.html"
                ) < 0.3
        );
    }
}
