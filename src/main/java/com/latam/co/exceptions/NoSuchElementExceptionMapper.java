package com.latam.co.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.NoSuchElementException;

@Provider
public class NoSuchElementExceptionMapper implements ExceptionMapper<NoSuchElementException> {

    public record ErrorMensaje(String msm, String detalles){

    }

    @Override
    public Response toResponse(java.util.NoSuchElementException e) {
        var error = new ErrorMensaje(e.getMessage(),e.getCause().getMessage());
        return Response.status(404).entity(error).build();
    }
}
