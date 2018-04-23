package websniffer.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtractionCriteria {

    @JsonProperty("entry_point_url")
    final public String entryPointUrl;
    final public Integer depth;

    public ExtractionCriteria() {
        this.entryPointUrl = "no_url";
        this.depth = 0;
    }
    public ExtractionCriteria(String entryPointUrl, Integer depth) {
        this.entryPointUrl = entryPointUrl;
        this.depth = depth;
    }
}
