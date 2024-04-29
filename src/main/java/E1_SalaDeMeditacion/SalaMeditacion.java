package E1_SalaDeMeditacion;

import java.util.concurrent.Semaphore;

import examen2.Comun;

public class SalaMeditacion {

    private int segundosEspera = 5;
    Semaphore salaSemaphore = new Semaphore(3);

    public void salaMeditacion(int idSamurai) throws InterruptedException {
        salaSemaphore.acquire();
        System.out.println(Comun.FechaActual() + " El samurai: " + idSamurai + " ha entrado en la sala de meditaci�n y espera " + segundosEspera + " segundos antes de salir.");
        Thread.sleep(3 * 1000);
        salaSemaphore.release();
    }

    public void salaMeditacionSinEspera(int idSamurai) throws InterruptedException {
        if (salaSemaphore.tryAcquire()) {
            System.out.println(Comun.FechaActual() + " El samurai: " + idSamurai + " ha entrado en la sala de meditaci�n y espera " + segundosEspera + " segundos antes de salir.");
            Thread.sleep(3 * 1000);
            salaSemaphore.release();
        } else {
            System.out.println(Comun.FechaActual() + " El samurai: " + idSamurai + " no entrado en la sala de meditaci�n porque no queria esperar a que hubiera un sitio libre");
        }

    }

}
