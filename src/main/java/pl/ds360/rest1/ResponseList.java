package pl.ds360.rest1;

import pl.ds360.rest1.model.Product;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ResponseList implements Serializable {

    private static final long serialVersionUID = 2L;
    @XmlElement(name = "product")
    private List<Product> list;

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
    public ResponseList() {
        super();
    }
    public ResponseList(List<Product> list) {
        super();
        this.list = list;
    }


}
