package websniffer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FibonaciiCoefficientGenerator {

    public FibonaciiCoefficientGenerator() {
        numbersSequence = new ArrayList<>();
        numbersSequence.add(1);
        numbersSequence.add(2);
    }

    private ArrayList<Integer> numbersSequence;

    public Float get(Integer index, Integer size) {
        return (float) Math.pow(getNumber(index), 2) / getNumbersPowerOfTwoSum(size).floatValue();
    }

    private Integer getNumber(Integer index) {
        if (numbersSequence.size() >= index) {
            return numbersSequence.get(index - 1);
        }
        numbersSequence.add(
                numbersSequence.get(numbersSequence.size() - 1) +
                        numbersSequence.get(numbersSequence.size() - 2)
        );
        return getNumber(index);
    }

    private Integer getNumbersPowerOfTwoSum(Integer index) {
        if (index > 1) {
            return getNumber(index) * getNumber(index) + getNumbersPowerOfTwoSum(index - 1);
        }
        return numbersSequence.get(0);
    }
}
