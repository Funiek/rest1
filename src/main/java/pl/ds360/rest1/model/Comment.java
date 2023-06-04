package pl.ds360.rest1.model;


import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Comment {
    private long id;
    private String context;

    public Comment() {}
    public Comment(long id, String context) {
        this.id = id;
        this.context = context;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
