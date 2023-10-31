package io.msdousti;

import jakarta.ws.rs.HEAD;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.zalando.logbook.jaxrs.LogbookServerFilter;

@Produces("application/json")
@Path("/")
public class MyController {

    @HEAD
    @Path("/handler/{handler}")
    public Response checkUserByHandler(@PathParam("handler") String handler) {
        return Response.ok().build();
    }

}
