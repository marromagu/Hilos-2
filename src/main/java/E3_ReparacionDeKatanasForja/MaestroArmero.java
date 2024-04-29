package E3_ReparacionDeKatanasForja;

import examen2.Comun;

public class MaestroArmero {
	int id;
	ForjaKatana f;

	public MaestroArmero(int id, ForjaKatana f) {
		this.id = id;
		this.f = f;
	}

	public void Empezar_a_trabajarEnLaForja() {
		try {
			f.TrabajarReparandoKatanas(this);
		} catch (InterruptedException e) {
		}
	}
}
