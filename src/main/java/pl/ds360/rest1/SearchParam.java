package pl.ds360.rest1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class SearchParam implements Serializable {
    private static final long serialVersionUID = 5L;
    String nazwa;
    double cenaMniejszaNiz;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCenaMniejszaNiz() {
        return cenaMniejszaNiz;
    }

    public void setCenaMniejszaNiz(double cenaMniejszaNiz) {
        this.cenaMniejszaNiz = cenaMniejszaNiz;
    }

    public SearchParam(String nazwa, double cenaMniejszaNiz) {
        super();
        this.nazwa = nazwa;
        this.cenaMniejszaNiz = cenaMniejszaNiz;
    }

    public SearchParam(){
        super();
    }
}
