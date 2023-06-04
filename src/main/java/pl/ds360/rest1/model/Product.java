package pl.ds360.rest1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
@XmlRootElement
@XmlType(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private double price;


    public Product() {
        super();
    }
    public Product(long id, String name, double price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
