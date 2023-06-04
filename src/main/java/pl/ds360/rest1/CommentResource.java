package pl.ds360.rest1;

import pl.ds360.rest1.model.Comment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public class CommentResource {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Comment get() {
        return new Comment(1, "Komentarz!");
    }
}