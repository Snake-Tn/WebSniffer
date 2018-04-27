package websniffer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FibonaciiCoefficientGeneratorTest {

    @InjectMocks
    private FibonaciiCoefficientGenerator fibonaciiCoefficientGenerator;

    @Test
    public void test_generator() {
        Float coefficientSum = 0f;
        for (int i = 1; i <= 10; i++) {
            coefficientSum += fibonaciiCoefficientGenerator.get(i, 10);
        }
        Assert.assertEquals(new Float(1), coefficientSum);
    }
}
