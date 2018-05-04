package websniffer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import websniffer.Model.ExtractionCriteria;


@RestController
public class CrawlController {
    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping(method = RequestMethod.POST, path = "crawl")
    public String crawl(@RequestBody() ExtractionCriteria extractionCriteria) {
        jmsTemplate.convertAndSend("url_extract", extractionCriteria);
        return "OK";
    }
}
