package E3_ReparacionDeKatanasForja;

import java.util.ArrayList;

import examen2.Comun;

public class Principal3 {

    int totalSamurais = 20;
    int totalTrabajadores = 2;

    public static void main(String[] args) throws Exception {
        Principal3 p = new Principal3();
        System.out.println("Ejercicio 3, Reparaci�n de katanas, forja ");

//        System.out.println("3.1	Samur�i deja la katana el mismo en la estanter�a");
//        p.samuraiDejaKatanaElmismo();
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        System.out.println("3.2	Maestro armero deja de trabajar");
//        p.maestroArmeroEspia();
//        System.out.println("");
//        System.out.println("");
//        System.out.println("");
//        System.out.println("3.3.1	Portero con espera del samur�i");
//        p.samuraiDejarKatanaConPorteroY_SI_esperaAlPortero();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("3.3.2	Portero sin espera del samur�i");
        p.samuraiDejarKatanaConPorteroY_NO_esperaAlPortero();
    }

    private void samuraiDejaKatanaElmismo() throws InterruptedException {
        ForjaKatana forja = new ForjaKatana();
        ArrayList<Samurai> samuraisArray = crearSamurais(forja);
        ArrayList<MaestroArmero> maestrosArmerosArray = crearMaestrosArmeros(forja);

        ArrayList<Thread> hilosSamurais = new ArrayList<Thread>();
        ArrayList<Thread> hilosTrabajadores = new ArrayList<Thread>();

        for (Samurai s : samuraisArray) {
            Thread t = new Thread(() -> s.samuraiDejaKatanaElmismo());
            hilosSamurais.add(t);
        }

        for (MaestroArmero ma : maestrosArmerosArray) {
            Thread t = new Thread(() -> ma.Empezar_a_trabajarEnLaForja());
            hilosTrabajadores.add(t);
        }

        for (Thread hilosTrabajadore : hilosTrabajadores) {
            hilosTrabajadore.start();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.start();
        }
        for (Thread hilosTrabajadore : hilosTrabajadores) {
            hilosTrabajadore.join();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.join();
        }
    }

    private void maestroArmeroEspia() throws InterruptedException {
        ForjaKatana forja = new ForjaKatana();
        ArrayList<Samurai> samurais = crearSamurais(forja);
        ArrayList<MaestroArmero> maestrosArmeros = crearMaestrosArmeros(forja);

        ArrayList<Thread> hilosSamurais = new ArrayList<Thread>();
        ArrayList<Thread> hilosTrabajadores = new ArrayList<Thread>();

        for (Samurai s : samurais) {
            Thread t = new Thread(() -> s.samuraiDejaKatanaElmismo());
            hilosSamurais.add(t);
        }

        for (MaestroArmero ma : maestrosArmeros) {
            Thread t = new Thread(() -> ma.Empezar_a_trabajarEnLaForja());
            hilosTrabajadores.add(t);
        }
        for (Thread hilosTrabajadore : hilosTrabajadores) {
            hilosTrabajadore.start();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.start();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.join();
        }
        Thread.sleep(6 * 1000);
        if (hilosTrabajadores.get(1).isAlive()) {
            hilosTrabajadores.get(1).interrupt();
        }
        int idMaestroArmero = 0; //Variable creada para que no de error
        System.out.println(Comun.FechaActual() + " ESP�A Se ha interrupido el hilo de este Maestro Armero " + idMaestroArmero
                + " se deben haber dado cuenta de que es un ESP�A y ser� ejecutado");

    }

    private void samuraiDejarKatanaConPorteroY_SI_esperaAlPortero() throws InterruptedException {

        ForjaKatana forja = new ForjaKatana();
        ArrayList<Samurai> samurais = crearSamurais(forja);
        ArrayList<MaestroArmero> maestrosArmeros = crearMaestrosArmeros(forja);

        ArrayList<Thread> hilosSamurais = new ArrayList<Thread>();
        ArrayList<Thread> hilosTrabajadores = new ArrayList<Thread>();

        for (Samurai s : samurais) {
            Thread t = new Thread(() -> s.samuraiDejarKatanaConPorteroY_SI_esperaAlPortero());
            hilosSamurais.add(t);
        }

        for (MaestroArmero ma : maestrosArmeros) {
            Thread t = new Thread(() -> ma.Empezar_a_trabajarEnLaForja());
            hilosTrabajadores.add(t);
        }
        for (Thread hilosTrabajadore : hilosTrabajadores) {
            hilosTrabajadore.start();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.start();
        }
        for (Thread hilosTrabajadore : hilosTrabajadores) {
            hilosTrabajadore.join();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.join();
        }

    }

    private void samuraiDejarKatanaConPorteroY_NO_esperaAlPortero() throws InterruptedException {
        ForjaKatana forja = new ForjaKatana();
        ArrayList<Samurai> samurais = crearSamurais(forja);
        ArrayList<MaestroArmero> maestrosArmeros = crearMaestrosArmeros(forja);

        ArrayList<Thread> hilosSamurais = new ArrayList<Thread>();
        ArrayList<Thread> hilosTrabajadores = new ArrayList<Thread>();

        for (Samurai s : samurais) {
            Thread t = new Thread(() -> s.samuraiDejarKatanaConPorteroY_NO_esperaAlPortero());
            hilosSamurais.add(t);
        }

        for (MaestroArmero ma : maestrosArmeros) {
            Thread t = new Thread(() -> ma.Empezar_a_trabajarEnLaForja());
            hilosTrabajadores.add(t);
        }

        for (Thread hilosTrabajadore : hilosTrabajadores) {
            hilosTrabajadore.start();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.start();
        }
        for (Thread hilosTrabajadore : hilosTrabajadores) {
            hilosTrabajadore.join();
        }
        for (Thread hilosSamurai : hilosSamurais) {
            hilosSamurai.join();
        }
    }

    private ArrayList<Samurai> crearSamurais(ForjaKatana forja) {
        var samurais = new ArrayList<Samurai>();
        int identificador = 1;
        for (int i = 0; i < totalSamurais; i++) {
            Samurai s = new Samurai(identificador, forja);
            samurais.add(s);
            identificador++;
        }
        return samurais;
    }

    private ArrayList<MaestroArmero> crearMaestrosArmeros(ForjaKatana forja) {
        var trabajadores = new ArrayList<MaestroArmero>();
        int identificador = 1;
        for (int i = 0; i < totalTrabajadores; i++) {
            MaestroArmero s = new MaestroArmero(identificador, forja);
            trabajadores.add(s);
            identificador++;
        }
        return trabajadores;
    }
}
