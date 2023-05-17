package pl.ds360.rest1;

import pl.ds360.rest1.model.Message;
import pl.ds360.rest1.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();

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
    public Message get(@PathParam("messageId") Long messageId) {
        return messageService.getMessage(messageId);
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
    public Message create(Message message) {
        return messageService.addMessage(message);
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
}