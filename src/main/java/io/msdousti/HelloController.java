package io.msdousti;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HEAD;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.TEXT_PLAIN)
@Path("/hello")
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello, World!\n";
    }

    @HEAD
    public Response returnOk() {
        return Response.ok().build();
    }

}
