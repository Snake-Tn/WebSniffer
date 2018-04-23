package websniffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import websniffer.Model.ExtractionCriteria;

import java.util.ArrayList;

@RestController
public class UrlController {

    @Autowired
    UrlExtractor urlExtractor;

    @RequestMapping(method = RequestMethod.POST, path = "url/extract")
    public ArrayList collectUrls(@RequestBody() ExtractionCriteria extractionCriteria) {
        return urlExtractor.extract(extractionCriteria);
    }
}
