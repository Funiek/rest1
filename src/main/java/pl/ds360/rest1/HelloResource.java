package pl.ds360.rest1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/echo")
    @Produces(MediaType.TEXT_PLAIN)
    public String echo() {
        return "echo";
    }

    @GET
    @Path("/echo2/{parametr}")
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(@PathParam("parametr") String name) {
        return "echo " + name;
    }
}