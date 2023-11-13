package net.salesianos.threads;

import net.salesianos.features.Almacen;

public class Consumidor extends Thread {

    private Almacen almacen;
    private int numeroDeVerdurasAConsumir;
    private int tiempoMaximoDeConsumicion;
    private String nombre;

    public Consumidor ( String nombre , int numeroDeVerdurasAConsumir , int tiempoMaximoDeConsumicion, Almacen almacen){
        this.numeroDeVerdurasAConsumir = numeroDeVerdurasAConsumir;
        this.nombre = nombre;
        this.tiempoMaximoDeConsumicion = tiempoMaximoDeConsumicion;
        this.almacen = almacen;
    }

    private int tiempoDeConsumicionAleatorio(){
        int valor = (int)Math.floor(Math.random()*(this.tiempoMaximoDeConsumicion)+1000);
        return valor;
    }

    @Override
    public void run(){
        for (int i = 0; i < numeroDeVerdurasAConsumir; i++) {
            try {
                sleep(tiempoDeConsumicionAleatorio());
                almacen.consumir(nombre);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
    }
    
}
