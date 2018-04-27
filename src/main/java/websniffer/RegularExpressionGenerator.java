package websniffer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RegularExpressionGenerator {


    private ArrayList<String> patternsSet;

    public RegularExpressionGenerator() {
        patternsSet = new ArrayList<>();
        patternsSet.add("[a-zA-Z]+");
        patternsSet.add("[0-9]+");
    }

    public String generate(String subject) {

        for (String patternExpression : patternsSet) {
            subject = subject.replaceAll(patternExpression, patternExpression);
        }
        if (subject.length() > 30) {
            subject = ".+";
        }
        return subject;
    }

}
