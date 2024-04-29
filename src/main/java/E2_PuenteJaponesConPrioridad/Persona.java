package E2_PuenteJaponesConPrioridad;

import examen2.Comun.Tipo;

public class Persona extends Thread {
	private Tipo tipo;
	private int identificador;
	private Puente c;
	
	public Persona(Puente c, int identificador, Tipo tipo) {
		this.identificador=identificador;
		this.tipo = tipo;
		this.c=c;
	}
	
	public int getIdentificador() {
		return identificador;
	}


	public Tipo getTipo() {
		return tipo;
	}




	@Override
	public void run() 
	{
		try {
			c.PersonaEntraYsale(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "\tPersona con ID:\t"+identificador + "\tTipo: "+tipo;
	}

}
