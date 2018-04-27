package websniffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class UrlResemblanceCalculator {

    @Autowired
    private RegularExpressionGenerator regularExpressionGenerator;

    @Autowired
    private FibonaciiCoefficientGenerator fibonaciiCoefficientGenerator;

    @Autowired
    private CommonRateUrlPartCalculator commonRateUrlPartCalculator;

    public Float calculate(String a, String b) {
        Float score = 0f;
        ArrayList<String> aParts = new ArrayList<>(Arrays.asList(a.split("/")));
        ArrayList<String> bParts = new ArrayList<>(Arrays.asList(b.split("/")));
        Integer minPartsSize = Math.min(aParts.size(), bParts.size());

        for (int i = 0; i < minPartsSize; i++) {
            String aPart = aParts.get(i);
            String bPart = bParts.get(i);
            Float partIndexCoefficient = fibonaciiCoefficientGenerator.get(minPartsSize - i, minPartsSize);

            if (aPart.equals(bPart)) {
                score += partIndexCoefficient;
                continue;
            }

            if (regularExpressionGenerator.generate(aPart).equals(regularExpressionGenerator.generate(bPart))) {
                score += partIndexCoefficient * (1 - commonRateUrlPartCalculator.calculate(aPart) * commonRateUrlPartCalculator.calculate(bPart));
            }
        }
        return score;
    }
}
