import net.salesianos.features.Almacen;
import net.salesianos.threads.Consumidor;
import net.salesianos.threads.Productor;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen(5);

        Productor Paquito = new Productor("Paquitoo", 5, almacen);
        Consumidor Loquendito = new Consumidor("Loquendito", 5 ,2000 ,almacen);
    
        Paquito.start();
        Loquendito.start();

        try {
            Paquito.join();
            Loquendito.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

