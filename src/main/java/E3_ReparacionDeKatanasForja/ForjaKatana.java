package E3_ReparacionDeKatanasForja;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import examen2.Comun;

public class ForjaKatana {

    private int totalHuecoEstanteriaEnForja = 5;
    ArrayBlockingQueue<Samurai> estanteriaQueue = new ArrayBlockingQueue<>(totalHuecoEstanteriaEnForja);
    Semaphore salaEspera = new Semaphore(totalHuecoEstanteriaEnForja);
    Semaphore portero = new Semaphore(1);

    public void samuraiDejaKatanaElmismo(Samurai samurai) throws InterruptedException {
        Imprimir(Comun.FechaActual() + "++ El samurai " + samurai.id + " llega a la estanteria y se queda esperando a que haya hueco para dejar la katana");
        estanteriaQueue.put(samurai);
        Imprimir(Comun.FechaActual() + "+ El samurai " + samurai.id + " ha dejado la katana en la estanteria y se va");

    }

    public void TrabajarReparandoKatanas(MaestroArmero ma) throws InterruptedException {
        int idKatana = -1;
        while (true) {
            Imprimir(Comun.FechaActual() + "--- El Maestro Armero " + ma.id + " espera a que haya una katana en la estanteria");
            Samurai miSamurai = estanteriaQueue.take();
            idKatana = miSamurai.id;
            Imprimir(Comun.FechaActual() + "-- El Maestro Armero " + ma.id + " quita la katana " + idKatana + " de la estanteria y empieza a repararla");
            Thread.sleep(3000);
            Imprimir(Comun.FechaActual() + "- El Maestro Armero " + ma.id + " termina de reparar katana " + idKatana);
        }
    }

    public void samuraiDejarKatanaConPorteroY_SI_esperaAlPortero(Samurai samurai) throws InterruptedException {
        salaEspera.acquire();
        Imprimir(Comun.FechaActual() + " El samurai " + samurai.id + " ha entrado en la sala de espera");

        portero.acquire();
        porteroRecoge(samurai);
        portero.release();

        Imprimir(Comun.FechaActual() + " El samurai " + samurai.id + " ha salido de la sala de espera, despues de esperar que el portero vuelva a la puerta");
        salaEspera.release();
    }

    private void porteroRecoge(Samurai samurai) throws InterruptedException {
        Imprimir(Comun.FechaActual() + " El Portero recoge la katana " + samurai.id + " y camina hacia la estanteria");
        Thread.sleep(1000);
        estanteriaQueue.put(samurai);
        Imprimir(Comun.FechaActual() + " El Portero ha dejado la katana " + samurai.id + " en la estanteria");
        Thread.sleep(1000);
        Imprimir(Comun.FechaActual() + " El Portero ha vuelto a la puerta");
    }

    public void samuraiDejarKatanaConPorteroY_NO_esperaAlPortero(Samurai samurai) throws InterruptedException {
        salaEspera.acquire();
        Imprimir(Comun.FechaActual() + " El samurai " + samurai.id + " ha entrado en la sala de espera");
        Imprimir(Comun.FechaActual() + " El samurai " + samurai.id + " ha salido de la sala de espera sin esperar a que el portero vuelva");
        portero.acquire();
        salaEspera.release();
        porteroRecoge(samurai);
        portero.release();

    }

    private void Imprimir(String value) {
        System.out.println(value);
        System.out.flush();
    }

}
