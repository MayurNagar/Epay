package com.example.jersey;

import com.example.serializationClass.SerializeUserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Mayur on 09-10-2017.
 */
@Path("/registration")
public class UserRegistration {


    /*
    Check whether user is already registered or not if not then proceed else throw user already registered message
     */
    @Path("/{id}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String isRegistered(@PathParam("id") String id){
        /*
        Database query   user is valid or not
         */

        /*
        if database request comes to be true
        set variable id = (PathParam)id else null
         */
        return "hello";
    }

    /*
    check if it matches someone else fingerprint as a user cannot register twice
     */
    @Path("/{fingerprint}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String isFingerprint(@PathParam("fingerprint") String fp){
        /*
        Database query whether that finger print string already exist in the database or not
         */

        return "Hello its me!";
    }

    /*
        Request database to the store new user
    */
    @Path("/{resgister}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SerializeUserData insertIntoDatabase(@PathParam("register") SerializeUserData serializeUserData) throws JsonProcessingException {
        SerializeUserData sua = new SerializeUserData(serializeUserData.getRollNumber(), serializeUserData.getFingerPrint());

        ObjectMapper objectMapper = new ObjectMapper();

        String userRegistration = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sua);
        System.out.println(userRegistration);

        return sua;
    }

}
