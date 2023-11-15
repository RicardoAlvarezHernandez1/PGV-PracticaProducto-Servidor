import net.salesianos.features.Almacen;
import net.salesianos.threads.Consumidor;
import net.salesianos.threads.Productor;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(20);

        Productor Paquito = new Productor("Paquitoo", 10, almacen);
        Productor Ramoncin = new Productor("Ramoncín", 10, almacen);
        Consumidor Faustinito = new Consumidor("Faustino", 5 , 3000,almacen);
        Consumidor MrGentlemansito = new Consumidor("Mr. Gentlemansito", 10, 6000,almacen);
        Consumidor Loquendito = new Consumidor("Loquendito", 5 ,2000 ,almacen);
    

        Paquito.setPriority(Thread.MAX_PRIORITY);
        Ramoncin.setPriority(Thread.MAX_PRIORITY);

        Faustinito.setPriority(Thread.MIN_PRIORITY);
        MrGentlemansito.setPriority(Thread.MIN_PRIORITY);
        Loquendito.setPriority(Thread.MIN_PRIORITY);

        Paquito.start();
        Ramoncin.start();

        Faustinito.start();
        MrGentlemansito.start();
        Loquendito.start();

        try {
            Paquito.join();
            Ramoncin.join();
            Faustinito.join();
            MrGentlemansito.join();
            Loquendito.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

