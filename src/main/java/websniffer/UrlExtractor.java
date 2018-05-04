package websniffer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import websniffer.Model.ExtractionCriteria;
import websniffer.Model.Link;
import websniffer.Repository.LinkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class UrlExtractor {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private ChromeDriver webDriver;

    @Autowired
    JmsTemplate jmsTemplate;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(UrlExtractor.class);


    @JmsListener(destination = "url_extract")
    public void excecute(ExtractionCriteria extractionCriteria) {
        ArrayList links = this.extract(extractionCriteria);
        linkRepository.insert(links);
    }

    public ArrayList<Link> extract(ExtractionCriteria extractionCriteria) {
        logger.info(String.format("start urls extraction for entry point [%s]", extractionCriteria.entryPointUrl));
        webDriver.get(extractionCriteria.entryPointUrl);
        List<WebElement> linkElements = webDriver.findElementsByTagName("a");

        ArrayList<Link> links = new ArrayList<Link>();
        for (WebElement linkElement : linkElements) {
            links.add(new Link(linkElement.getAttribute("href")));
        }
        links.removeIf(s -> s.url == null || !s.url.startsWith("http"));
        logger.info(String.format("urls extraction is done for entry point [%s]", extractionCriteria.entryPointUrl));
        return links;
    }

}
