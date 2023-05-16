package pl.ds360.rest1;

import pl.ds360.rest1.model.Message;
import pl.ds360.rest1.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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