package E1_SalaDeMeditacion;

public class Samurai {
	int i;
	SalaMeditacion salaArte;

	public Samurai(int i, SalaMeditacion salaArte) {
		this.i = i;
		this.salaArte = salaArte;
	}

	public void entrarSalaMeditacion() {
		try {
			salaArte.salaMeditacion(i);
		} catch (InterruptedException e) {
		}
	}

	public void entrarSalaMeditacionSinEspera() {
		try {
			salaArte.salaMeditacionSinEspera(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}

}
