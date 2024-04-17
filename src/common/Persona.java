package common;

import java.io.Serializable;

public class Persona implements Serializable {

	private static final long serialVersionUID = 3766935390701465202L;
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	String nombre;
	int edad;
	
	@Override
	public String toString() {
		return (nombre + ", " + edad + "años.");
	}
	
}
