package dev.christianpetzold.api;

import dev.christianpetzold.application.GameApplication;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Path("/game")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class GameResource {

    private final @NonNull GameApplication gameApplication;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("guess")
    public Response guessPlayer() {
        return Response.ok().entity(gameApplication.getRandomPlayerGuessingInfo()).build();
    }

}

