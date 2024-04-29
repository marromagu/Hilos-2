package E3_ReparacionDeKatanasForja;

public class Samurai {
	int id;
	ForjaKatana f;

	public Samurai(int id, ForjaKatana f) {
		this.id = id;
		this.f = f;
	}

	public void samuraiDejaKatanaElmismo() {
		try {
			f.samuraiDejaKatanaElmismo(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void samuraiDejarKatanaConPorteroY_SI_esperaAlPortero() {
		try {
			f.samuraiDejarKatanaConPorteroY_SI_esperaAlPortero(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void samuraiDejarKatanaConPorteroY_NO_esperaAlPortero() {
		try {
			f.samuraiDejarKatanaConPorteroY_NO_esperaAlPortero(this);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
