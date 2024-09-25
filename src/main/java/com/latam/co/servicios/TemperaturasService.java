package com.latam.co.servicios;

import com.latam.co.entidades.ETemperatura;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TemperaturasService {
    private List<ETemperatura> temperaturas= List.of(
            new ETemperatura("Bogotá",29,32),
            new ETemperatura("Medellin",25,30),
            new ETemperatura("Pereira",28,42));
    public void agregar(ETemperatura temperatura){
        temperaturas.add(temperatura);
    }
    public List<ETemperatura> mostrarTemperaturas(){
        return Collections.unmodifiableList(temperaturas);
    }
    public int temperaturaMaxima(){
        return temperaturas.stream().mapToInt(ETemperatura::getMaxima).max().getAsInt();
    }
    public Optional<ETemperatura> traerCiudad(String ciudad){
        return temperaturas.stream().filter(t->t.getCiudad().equalsIgnoreCase(ciudad)).findAny();
    }
}
