package N1E1;
/*
	En un grup de música hi ha diferents tipus d’instruments musicals. 
	Hi ha instruments de vent, de corda i de percussió.
	Tots els instruments tenen com a atributs el seu nom, i el seu preu. 
	A més, tenen un mètode anomenat tocar(). Aquest, és abstracte a la classe instrument i, per tant, s’ha d’implementar a les classes filles. 
	Si s’està tocant un instrument de vent, el mètode ha de mostrar per consola: "Està sonant un instrument de vent", si s’està tocant un instrument de corda: “Està sonant un instrument de corda” i si s’està tocant un instrument de percussió: “Està sonant un instrument de percussió”.
	El procés de càrrega d'una classe només té lloc una vegada. 
	Demostra que la càrrega pot ser provocada per la creació de la primera instància d'aquesta classe o per l'accés a un membre estàtic d'aquesta. 
	Cerca informació sobre els blocs d'inicialització i blocs estàtics en Java.
*/

import java.util.ArrayList;

public class Main {

	static ArrayList<Instrumento> Instrumentos = new ArrayList<Instrumento>();

	public static void main(String[] args) {
		// Info
		int randomNum = 0;
		
		// Logic
		crearInstViento("flauta", 30);
		crearInstCuerda("violin", 150);
		crearInstPercusion("tambor", 200);

		randomNum = (int) Math.floor(Math.random() * Instrumentos.size());
		// System.out.println(randomNum);
		
		// Out
		System.out.println(Instrumentos.get(randomNum).tocar());
		System.out.println(Instrumento.dejarDeTocar());
	}

	public static void crearInstViento(String nombre, double precio) {
		InstrumentoViento viento = new InstrumentoViento(nombre, precio);
		Instrumentos.add(viento);
	}

	public static void crearInstCuerda(String nombre, double precio) {
		InstrumentoCuerda cuerda = new InstrumentoCuerda(nombre, precio);
		Instrumentos.add(cuerda);
	}

	public static void crearInstPercusion(String nombre, double precio) {
		InstrumentoPercusion percusion = new InstrumentoPercusion(nombre, precio);
		Instrumentos.add(percusion);
	}
}
