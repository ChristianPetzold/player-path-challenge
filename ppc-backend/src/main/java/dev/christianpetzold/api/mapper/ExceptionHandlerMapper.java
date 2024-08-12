package dev.christianpetzold.api.mapper;

import com.google.gson.Gson;
import dev.christianpetzold.api.dto.ErrorDTO;
import jakarta.annotation.Priority;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

@Provider
@Priority(9999)
public class ExceptionHandlerMapper implements ExceptionMapper<Throwable> {


    @Override
    @ServerExceptionMapper
    public Response toResponse(Throwable e) {
        Gson gson = new Gson();

        if (e instanceof WebApplicationException ex) {
            return Response.status(ex.getResponse().getStatus())
                    .entity(
                            gson.toJson(
                                    ErrorDTO.builder()
                                            .errorCode(ex.getResponse().getStatusInfo().toEnum().toString())
                                            .message(ex.getMessage())
                                            .build()))
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(gson.toJson(ErrorDTO.builder()
                            .errorCode(String.valueOf(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()))
                            .message("Oops! Something went wrong.")
                            .build()))
                    .build();
        }
    }
}
