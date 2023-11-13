package net.salesianos.features;

import java.util.ArrayList;

public class Almacen {
    public ArrayList<String> verduras = new ArrayList<>();
    private int size;

    public Almacen(int size){
        this.size = size;
    }

    public synchronized void producir(String nombre , String verdura) throws InterruptedException{
        while (verduras.size() == this.size) {
            wait();
        }
        
        System.out.println("Ha crecido una verdura : " + verdura + ". " + nombre + " la llevará al almacén");
        verduras.add(verdura);
        notifyAll();
    }

    public synchronized void consumir(String nombre) throws InterruptedException{
        while(verduras.size() == 0) {
            wait();
        }

        System.out.println(nombre + " ha consumido una verdura : " + verduras.remove(0));
        notifyAll();
    }   
}
