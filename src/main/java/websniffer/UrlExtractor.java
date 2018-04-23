package websniffer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;
import websniffer.Model.ExtractionCriteria;


import java.util.ArrayList;
import java.util.List;

@Component
public class UrlExtractor {

    public ArrayList<String> extract(ExtractionCriteria extractionCriteria) {
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get(extractionCriteria.entryPointUrl);
        List<WebElement> linkElements = webDriver.findElementsByTagName("a");

        ArrayList<String> links = new ArrayList<>();
        for (WebElement linkElement : linkElements) {
            links.add(linkElement.getAttribute("href"));
        }
        links.removeIf(s -> s == null);
        return links;
    }

}
