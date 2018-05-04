package websniffer.Model;

import java.util.ArrayList;

public class Page {

    public final ArrayList<Link> links;
    public final Integer imagesCount;
    public final Integer linksCount;

    public Page(ArrayList<Link> links, Integer imagesCount, Integer linksCount) {
        this.links = links;
        this.imagesCount = imagesCount;
        this.linksCount = linksCount;
    }
}
