package com.latam.co.entidades;

public class ETemperatura {
    private String ciudad;
    private int minima;
    private int maxima;

    public ETemperatura() {
    }

    public ETemperatura(String ciudad, int minima, int maxima) {
        this.ciudad = ciudad;
        this.minima = minima;
        this.maxima = maxima;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getMinima() {
        return minima;
    }

    public void setMinima(int minima) {
        this.minima = minima;
    }

    public int getMaxima() {
        return maxima;
    }

    public void setMaxima(int maxima) {
        this.maxima = maxima;
    }

    @Override
    public String toString() {
        return "ETemperatura{" +
                "ciudad='" + ciudad + '\'' +
                ", minima=" + minima +
                ", maxima=" + maxima +
                '}';
    }
}
