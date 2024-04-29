package E1_SalaDeMeditacion;

import java.util.ArrayList;

public class Principal1 {

    int samuraisTotal = 10;

    public void samuraiSalaMeditacion() throws InterruptedException {
        SalaMeditacion salaMeditacion = new SalaMeditacion();
        ArrayList<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < samuraisTotal; i++) {
            Samurai miSamurai = new Samurai(i, salaMeditacion);
            Thread hilo = new Thread(() -> miSamurai.entrarSalaMeditacion());
            hilos.add(hilo);
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }

    }

    public void samuraiSalaMeditacionSinEspera() throws InterruptedException {
        SalaMeditacion salaMeditacion = new SalaMeditacion();
        ArrayList<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < samuraisTotal; i++) {
            Samurai miSamurai = new Samurai(i, salaMeditacion);
            Thread hilo = new Thread(() -> miSamurai.entrarSalaMeditacionSinEspera());
            hilos.add(hilo);
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            hilo.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Principal1");
        Principal1 miPrincipal = new Principal1();

//        System.out.println("1.1 Sala de meditaci�n ");
//        miPrincipal.samuraiSalaMeditacion();

        //Thread.sleep(5000);
        
        System.out.println("1.2 Sala de meditaci�n sin espera ");
        miPrincipal.samuraiSalaMeditacionSinEspera();
    }

}
