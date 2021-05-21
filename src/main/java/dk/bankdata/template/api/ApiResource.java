package dk.bankdata.template.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/template")
public class ApiResource {

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String name() {
        return "template-java-quarkus-1x";
    }

    @GET
    @Path("/version")
    @Produces(MediaType.TEXT_PLAIN)
    public String version() {
        return "1.0.0";
    }

}
