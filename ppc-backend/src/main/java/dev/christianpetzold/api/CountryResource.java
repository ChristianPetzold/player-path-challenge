package dev.christianpetzold.api;

import dev.christianpetzold.repository.NationalityRepository;
import dev.christianpetzold.repository.entities.Nationality;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Path("/country")
public class CountryResource {

    @Inject
    NationalityRepository nationalityRepository;

    @GET
    @Produces("image/webp")
    @Path("flag/id/{countryId}")
    public Response getFlag(@PathParam("countryId") String countryIdString) {
        UUID countryId;
        try {
            countryId = UUID.fromString(countryIdString);
        } catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").build();
        }

        Nationality nationality = nationalityRepository.findById(countryId);

        try (InputStream imageStream = getClass().getResourceAsStream("/files/banners/" + nationality.getBannerFileName())) {
            assert imageStream != null;
            byte[] imageBytes = imageStream.readAllBytes();
            return Response.ok(imageBytes).type("image/webp").build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
