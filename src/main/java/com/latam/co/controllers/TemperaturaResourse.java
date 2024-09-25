package com.latam.co.controllers;

import com.latam.co.entidades.ETemperatura;
import com.latam.co.servicios.TemperaturasService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("api/v1/temperatura")
public class TemperaturaResourse {

    private final TemperaturasService temperaturas;

    public TemperaturaResourse(TemperaturasService temperaturas) {
        this.temperaturas = temperaturas;
    }

    @GET
    @Path("/medicion")
    public ETemperatura medicion(){
        return new ETemperatura("Bogotá", 28,32);
    }

    @GET
    @Path("listado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ETemperatura> listadoDeTemperaturas(){
        return temperaturas.mostrarTemperaturas();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ETemperatura gestionarTemperatura(ETemperatura temperatura){
        temperaturas.agregar(temperatura);
        return temperatura;
    }
    @GET
    @Path("maxima")
    @Produces(MediaType.TEXT_PLAIN)
    public Response temperaturaMaxima(){
        //Response es equivalente a ResponseEntity;
        if (temperaturas.mostrarTemperaturas().size() ==0){
            //Construimos una respuesta
            return Response.status(404).entity("No hay una temperatura maxima").build();
        }else {
            int temperaturaMaxima= temperaturas.temperaturaMaxima();
            return Response.status(200)
                    .header("Respuesta","OK")
                    .entity(temperaturaMaxima)
                    .build();
        }
    }
    @GET
    @Path("/{ciuda}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sacarPorCiudad(@PathParam("ciuda") String ciudad){
        return Response.status(200).entity(temperaturas.traerCiudad(ciudad)).build();
    }

}
