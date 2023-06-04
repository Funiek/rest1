package pl.ds360.rest1.model;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Message {
    private long id;
    private String message;

    private List<Link> links;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Message() {}

    public Message(String message) {
        this.message = message;
    }
    public Message(long id, String message) {
        this.id = id;
        this.message = message;
        this.links = new ArrayList<>();
    }

    public Message(long id, String message, List<Link> links) {
        this.id = id;
        this.message = message;
        this.links = links;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addLink(String uri, String title) throws URISyntaxException {
        Link link = new MyLink(uri, title);

        for(Link l: links) {
          if(l.getTitle().equals(title))
              return;
        }
        links.add(link);
    }

}
