package com.latam.co.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.Optional;

@Path("/api/v1/saludar")
public class EcoController {
    @GET()
    public String saludar(){
        return "Hola Buenos Dias";
    }
    //Parametros por URLs

    @GET
    @Path("/{nombre}/grito")
    public String gritarNombre(@PathParam("nombre") String nombre){
        return "Que quieres ".toUpperCase()+nombre.toUpperCase();
    }
}
