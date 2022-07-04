package N3E1;

import java.util.ArrayList;

/**
La redacció pot tenir més d’un redactor, i de cadascun d’ells volem saber el seu nom, el DNI i el sou. 
Un cop assignat un DNI, aquest no podrà canviar mai. 
Tots els redactors tenen el mateix sou, i si en un futur l’empresa pot incrementar-lo, ho farà a tothom per igual. 
De moment el sou actual és de 1500 €.
Cada redactor pot treballar en més d’una notícia. 
*/

public class Redactor {
	// Atributos
	private String nombre;
	private final String dni;
	private static int sueldo;
	private ArrayList<Noticia> noticias;

	// Constructor
	public Redactor(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		sueldo = 1500;
		this.noticias = new ArrayList<Noticia>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static int getSueldo() {
		return sueldo;
	}

	public static void setSueldo(int sueldo) {
		Redactor.sueldo = sueldo;
	}

	public ArrayList<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(ArrayList<Noticia> noticias) {
		this.noticias = noticias;
	}

	public String getDni() {
		return dni;
	}
	//Generals
	
	public int findNewsRedac(String headline) {
		
		int arrayPosition = 0;
		boolean stop = false;
		if (this.getNoticias().size() != 0) {
			for (int i = 0; i < this.getNoticias().size() && stop == false; i++) {
				if (this.getNoticias().get(i).getHeadline().equalsIgnoreCase(headline)) {
					stop = true;
					arrayPosition = i;
				} else {
					arrayPosition = -1;
				}
			}
		} else {
			arrayPosition = -1;
		}
		return arrayPosition;
	}

	@Override
	public String toString() {
		return "Redactor [nombre=" + nombre + ", dni=" + dni + ", sueldo=" + sueldo + ", noticias=" + noticias + "]";
	}
}
