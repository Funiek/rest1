package pl.ds360.rest1;

import pl.ds360.rest1.model.Message;
import pl.ds360.rest1.service.MessageService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("messages")
public class MessageResource {

    @Inject
    private MessageService messageService;

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> xml() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> json() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAll() {
        return messageService.getAllMessages();
    }


    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message get(@PathParam("messageId") Long messageId, @Context UriInfo uriInfo) throws URISyntaxException {
        Message newMessage = messageService.getMessage(messageId);

        String uri = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(String.valueOf(newMessage.getId()))
                .build()
                .toString();

        newMessage.addLink(uri, "self");

        String uri2 = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path("comments")
                .build()
                .toString();

        newMessage.addLink(uri2, "comments");

        return newMessage;
    }

    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getQuery(@QueryParam("id") Long id) {
        return messageService.getMessage(id);
    }

    @GET
    @Path("/header")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHeader(@HeaderParam("Kubus") String header) {
        return header;
    }

    @GET
    @Path("/matrix")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMatrix(@MatrixParam("name") String name, @MatrixParam("department") String department) {
        return name + " " + department;
    }

    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo(@Context UriInfo uriInfo) {
        return uriInfo.getAbsolutePath().toString();
    }

    @GET
    @Path("/httpheaders")
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo(@Context HttpHeaders headers) {
        return headers.getHeaderString("Connection");
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Message message, @Context UriInfo uriInfo, @Context HttpServletResponse response) {
        Message newMessage = messageService.addMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();

        return Response.created(uri)
                .entity(newMessage)
                .build();
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message update(Message message) {
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void delete(@PathParam("messageId") Long messageId) {
        messageService.deleteMessage(messageId);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@QueryParam("zaczynasie") String par1 ) {
        if (par1 != null){
            return messageService.getAllMessagesStartingWith(par1);
        }
        return messageService.getAllMessages();
    }

    @Path("comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }
}