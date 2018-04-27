package websniffer;

import org.springframework.stereotype.Component;

@Component
public class CommonRateUrlPartCalculator {

    Float calculate(String urlPart) {
        return 1f / (float) Math.random();
    }
}
