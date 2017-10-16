package com.example.jersey;

import com.example.serializationClass.SerializeUserData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Mayur on 07-10-2017.
 */
@Path("/mydemo")
public class myJersey {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SerializeUserData do_get() throws IOException{
        SerializeUserData serializeUserData = new SerializeUserData();

        serializeUserData.setRollNumber("14bce061");
        serializeUserData.setFingerPrint("mayur");
        serializeUserData.setAuthenticated(Boolean.TRUE);

        return serializeUserData;
    }

    @POST
    @Path("/insertdata")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SerializeUserData insert(SerializeUserData serializeUserDataData){
        SerializeUserData serializeUserData = new SerializeUserData();

        serializeUserData.setRollNumber(serializeUserDataData.getRollNumber());
        serializeUserData.setFingerPrint(serializeUserDataData.getFingerPrint());
        serializeUserData.setAuthenticated(Boolean.TRUE);
        /*
            Database chores
         */
        System.out.println(serializeUserData);
        return serializeUserData;
    }

}
