package pl.ds360.rest1;

import pl.ds360.rest1.model.Product;
import pl.ds360.rest1.model.Products;

import javax.ws.rs.*;
import java.util.List;

@Path("/sklep")
public class SklepResource {
    @GET
    @Path("/allproducts")
    public ResponseList getAllProducts() {
        List<Product> products = Products.getProducts();
        ResponseList responseList = new ResponseList();
        responseList.setList(products);
        return responseList;
    }
}