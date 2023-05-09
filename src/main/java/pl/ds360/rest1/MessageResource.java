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
}