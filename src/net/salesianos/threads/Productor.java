package net.salesianos.threads;

import net.salesianos.features.Almacen;

public class Productor extends Thread {
    
    private Almacen almacen;
    private int verdurasAProducir;
    private String nombre;
    private String [] listaDeVerduras = new String[] {"lettuce" , "cabbage" , "onion" , "spinach" , "potato" , "celery" , "asparagus" , "radish" , "broccoli" , "artichoke" , "tomato" , "cucumber" , "eggplant" , "carrot" , "green bean"};

    public Productor ( String nombre ,int verdurasAProducir , Almacen almacen){
        this.verdurasAProducir = verdurasAProducir;
        this.nombre = nombre;
        this.almacen = almacen;
    }

    private int numeroAleatorio(){
        int valor = (int)Math.floor(Math.random()*(15));
        return valor;
    }

    private int tiempoDeCrecimientoAleatorio(){
        int valor = (int)Math.floor(Math.random()*(5000)+1000);
        return valor;
    }

    @Override
    public void run(){
        for (int i = 0; i < verdurasAProducir; i++) {

            String verdura = listaDeVerduras[numeroAleatorio()];
            try {
                sleep(tiempoDeCrecimientoAleatorio());
                almacen.producir(nombre , verdura);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

        }
    }
}
