package E2_PuenteJaponesConPrioridad;

import java.util.ArrayList;

import examen2.Comun.Tipo;

public class Principal2 {

    int totaPersonasPorTipo = 4;

    public void personasPrioridadTipo() throws InterruptedException {
        Puente miPuente = new Puente();
        ArrayList<Thread> hilosArrayList = crearPersonas(miPuente);
        for (Thread thread : hilosArrayList) {
            thread.start();
        }
        for (Thread thread : hilosArrayList) {
            thread.join();
        }

    }

    private ArrayList<Thread> crearPersonas(Puente c) {
        var hilos = new ArrayList<Thread>();
        int identificador = 0;
        for (int i = 0; i < totaPersonasPorTipo; i++) {
            var v = new Persona(c, identificador, Tipo.Campesino);
            hilos.add(v);
            identificador++;
        }
        for (int i = 0; i < totaPersonasPorTipo; i++) {
            var v = new Persona(c, identificador, Tipo.Samurai);
            hilos.add(v);
            identificador++;
        }
        for (int i = 0; i < totaPersonasPorTipo; i++) {
            var v = new Persona(c, identificador, Tipo.Campesino);
            hilos.add(v);
            identificador++;
        }

        return hilos;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ejercicio 2, vehiculos con prioridad");
        var p = new Principal2();

        System.out.println("Ejercicio 2.1 prioridad por tipo persona");
        p.personasPrioridadTipo();

    }

}
