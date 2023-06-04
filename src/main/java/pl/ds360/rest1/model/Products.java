package pl.ds360.rest1.model;

import java.util.ArrayList;
import java.util.List;

public class Products {
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1L, "Maslo", 1.23));
        products.add(new Product(2L, "Chleb", 8.22));
        products.add(new Product(3L, "Pomarancze", 4.55));
        products.add(new Product(4L, "Pomarancze", 7.55));
        return products;
    }
}
