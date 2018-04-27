package websniffer;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegularExpressionGeneratorTest {

    @InjectMocks
    private RegularExpressionGenerator generator;

    @Test
    public void test_generate() {
        Assert.assertEquals("[a-zA-Z]+", generator.generate("abc"));
        Assert.assertEquals("[0-9]+", generator.generate("123"));
        Assert.assertEquals("[a-zA-Z]+[0-9]+", generator.generate("abc123"));
        Assert.assertEquals("[0-9]+[a-zA-Z]+", generator.generate("123abc"));
        Assert.assertEquals("[0-9]+[a-zA-Z]+[0-9]+[a-zA-Z]+", generator.generate("123abc123xyz"));
        Assert.assertEquals("[a-zA-Z]+-[0-9]+", generator.generate("abc-123"));
        Assert.assertEquals(".+", generator.generate("q8ew76q8w9e67q98we7"));
    }
}
