package pl.ds360.rest1;

import java.io.IOException;
import java.util.Base64;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
@Provider
public class MyResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext
            responseContext) throws IOException {

        responseContext.getHeaders().add("mojNaglowek", "rsi test");
        System.out.println("Response headers: " + responseContext.getHeaders());
    }

}
