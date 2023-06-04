package pl.ds360.rest1;

import pl.ds360.rest1.model.Product;
import pl.ds360.rest1.model.Products;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

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

    @GET
    @Path("/product")
    public Product getProduct() {
        List<Product> products = Products.getProducts();
        return products.get(1);
    }

    @POST
    @Path("/findProducts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public ResponseList findProducts(SearchParam searchElement) {
        List<Product> products = Products.getProducts().stream()
                .filter(p -> p.getName().equals(searchElement.getNazwa())
                        && p.getPrice() <= searchElement.getCenaMniejszaNiz())
                .collect(Collectors.toList());

        ResponseList responseList = new ResponseList();
        responseList.setList(products);
        return responseList;
    }
}