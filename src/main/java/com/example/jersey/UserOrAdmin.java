package com.example.jersey;

import com.example.serializationClass.SerializeUserOrAdmin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Mayur on 09-10-2017.
 */
@Path("/user_admin")
public class UserOrAdmin {


    /*
        Test from database whether the user is admin or student and according to that send message
        to front end about which page to open.

     */
    @Path("/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public SerializeUserOrAdmin getPage(@PathParam("id") String id) throws JsonProcessingException {

        SerializeUserOrAdmin serializeUserOrAdmin = new SerializeUserOrAdmin();
        serializeUserOrAdmin.setId(id);

        ObjectMapper objectMapper = new ObjectMapper();

        String UserOrAdminQuery = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(serializeUserOrAdmin);
        System.out.println(UserOrAdminQuery);

        // request to database

        return serializeUserOrAdmin;
    }

}
