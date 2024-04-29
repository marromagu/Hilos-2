package E2_PuenteJaponesConPrioridad;

import examen2.Comun;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Puente {

    ReentrantLock lock = new ReentrantLock();
    Condition samurai = lock.newCondition();
    Condition campesino = lock.newCondition();

    int personasMax = 3;
    int personaEnPuente = 0;

    int personasEsperando = 0;
    int samuraiEsperando = 0;
    int campesinoEsperando = 0;

    public void PersonaEntraYsale(Persona persona) throws Exception {
        intentaEntrar(persona);
        Thread.sleep(2 * 1000);
        sale(persona);
    }

    private void intentaEntrar(Persona persona) {
        try {
            lock.lock();
            while (personaEnPuente >= personasMax) {
                escribirPersonaEspera(persona);
                incrementarEspera(persona);
                if (persona.getTipo() == Comun.Tipo.Samurai) {
                    samurai.await();
                } else if (persona.getTipo() == Comun.Tipo.Campesino) {
                    campesino.await();
                }
                decrementarEspera(persona);
            }
            personaEnPuente++;
            escribirPersonaEntra(persona);
        } catch (InterruptedException ex) {
            Logger.getLogger(Puente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }

    }

    private void sale(Persona persona) {
        try {
            lock.lock();
            escribirPersonaSale(persona);
            personaEnPuente--;
            if (samuraiEsperando > 0) {
                samurai.signal();
            } else if (campesinoEsperando > 0) {
                campesino.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    private void escribirPersonaSale(Persona v) {
        System.out.println(Comun.FechaActual() + " Sale del puente" + v.toString());
    }

    private void escribirPersonaEspera(Persona v) {
        System.out.println(Comun.FechaActual() + " Espera en la entrada del puente" + v.toString());
    }

    private void escribirPersonaEntra(Persona v) {
        System.out.println(Comun.FechaActual() + " Entra en el puente" + v.toString() + " total personas esperando en el puente: " + personasEsperando + " Samurais: " + samuraiEsperando + " Campesino: " + campesinoEsperando);
    }

    private void incrementarEspera(Persona persona) {
        personasEsperando++;
        if (persona.getTipo() == Comun.Tipo.Samurai) {
            samuraiEsperando++;
        }
        if (persona.getTipo() == Comun.Tipo.Campesino) {
            campesinoEsperando++;
        }
    }

    private void decrementarEspera(Persona persona) {
        personasEsperando--;
        if (persona.getTipo() == Comun.Tipo.Samurai) {
            samuraiEsperando--;
        }
        if (persona.getTipo() == Comun.Tipo.Campesino) {
            campesinoEsperando--;
        }
    }
}
