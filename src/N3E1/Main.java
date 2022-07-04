package N3E1;

import java.util.ArrayList;
import java.util.Scanner;

/**
En una redacció de notícies esportives tenen les notícies classificades per esports: 
futbol, bàsquet, tenis, F1 i motociclisme.
La redacció pot tenir més d’un redactor, i de cadascun d’ells volem saber el seu nom, el DNI i el sou. 
Un cop assignat un DNI, aquest no podrà canviar mai. 
Tots els redactors tenen el mateix sou, i si en un futur l’empresa pot incrementar-lo, ho farà a tothom per igual. 
De moment el sou actual és de 1500 €.
Cada redactor pot treballar en més d’una notícia. 
Les notícies han de tenir un titular, un text, una puntuació i un preu. En el moment de crear-se, el text ha d’estar buit.
A més, de les notícies de futbol s’ha de saber a quina competició fa referència(String), a quin club(String) i a quin jugador(String).
De les notícies de bàsquet s’ha d’indicar a quina competició fa referència(String) i a quin club(String).
De les notícies de tenis s’ha de saber de quina competició(String) parlen i de quins tenistes(String).
De les notícies d'F1 hem de saber a quina escuderia(String) fan referència.
De les notícies de motociclisme s’ha d’indicar de quin equip(String) són.

Les notícies es venen a diferents mitjans. Per saber el preu de cada notícia hem d'implementar un mètode que es diu calcularPreuNoticia(). 
A continuació s’explica com calcular el preu de cada notícia:

Notícies de futbol: 
Preu inicial: 300 €
Lliga de Campions: 100 €
Barça o Madrid: 100 €
Ferran Torres o Benzema: 50 €
Exemple: Una notícia que parla d’un gol de Ferran Torres del Barça a la Lliga de Campions, té un preu de 550 €.

Notícies de bàsquet:
Preu inicial: 250 €
Eurolliga: 75 €
Barça o Madrid: 75 €

Notícies de tenis:
Preu inicial: 150 € 
Federer, Nadal o Djokovic: 100 €

Notícies d'F1:
Preu inicial: 100 €
Ferrari o Mercedes: 50 €

Notícies de motociclisme:
Preu inicial: 100 €
Honda o Yamaha: 50 €

Per calcular les puntuacions de les notícies se segueixen els següents criteris:
Notícies de futbol:
5 Punts.
Lliga de Campions: 3 punts
Lliga: 2 punts
Barça o Madrid: 1 punt
Ferran Torres o Benzema: 1 punt
Exemple: Una notícia que parla d’un gol de Ferran Torres del Barça a la Lliga de Campions, té una puntuació de 10 punts.


Notícies de bàsquet:
4 punts
Eurolliga: 3 punts
ACB: 2 punts
Barça o Madrid: 1 punt

Notícies de Tenis:
4 punts
Federer, Nadal o Djokovic: 3 punts

Notícies F1:
4 punts
Ferrari o Mercedes: 2 punts

Notícies de Motociclisme:
3 punts
Honda o Yamaha: 3 punts


A la classe principal s’ha de fer un menú amb les següents opcions:
1.- Introduir redactor.
2.- Eliminar redactor.
3.- Introduir notícia a un redactor.
4.- Eliminar notícia (ha de demanar redactor i titular de la notícia).
5.- Mostrar totes les notícies per redactor.
6.- Calcular puntuació de la notícia.
7.- Calcular preu-notícia.
 */

public class Main {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Redactor> redactors = new ArrayList<Redactor>();

	public static void main(String[] args) {
		// Data
		String mensaje = "";
		int opcion = 0;

		// Dialogo
		do {
			System.out.println("Escoja una opción: \n" + "0. Salir del programa. \n" + "1. Introducir redactor. \n"
					+ "2. Eliminar redactor. \n" + "3. Introducir noticia a un redactor. \n"
					+ "4. Eliminar notica de un redactor. \n" + "5. Mostrar todas las noticias de un redactor. \n"
					+ "6. Calcular puntuacion de la noticia. \n" + "7. Calcular precio de noticia. \n");

			opcion = entrada.nextInt();
			entrada.nextLine();

			switch (opcion) {
			case 1:
				mensaje = enterRedac();
				break;
			case 2:
				mensaje = removeRedac();
				break;
			case 3:
				mensaje = enterNewsRedac();
				break;
			case 4:
				mensaje = removeNewsRedac();
				break;
			case 5:
				mensaje = showNewsRedac();
				break;
			case 6:
				mensaje = calcScoreNews();
				break;
			case 7:
				mensaje = calcPriceNews();
				break;
			}
			System.out.println(mensaje);
		} while (opcion != 0);
		System.out.println("Adios");
	}

	// METODOS PRINCIPALES

	public static String enterRedac() {

		String resultado = "", nombre = "", dni = "";
		System.out.println("Introduzca el nombre del redactor");
		nombre = entrada.nextLine();
		System.out.println("Introduzca el DNI del redactor");
		dni = entrada.nextLine();
		Redactor redactor = new Redactor(nombre, dni);
		redactors.add(redactor);
		resultado = "Se ha creado e introducido en el sistema al redactor \n" + redactor.toString() + "\n";
		return resultado;
	}

	public static String removeRedac() {

		String resultado = "", dniBusc = "", nombreBusc = "";
		int posArrayRedac = 0;
		System.out.println("Introduzca el DNI del redactor a eliminar");
		dniBusc = entrada.nextLine();
		posArrayRedac = findRedacDni(dniBusc);
		if (posArrayRedac == -1) {
			resultado = "No se ha encontrado en el sistema, el redactor indicado.";
		} else {
			nombreBusc = redactors.get(posArrayRedac).getNombre();
			redactors.remove(posArrayRedac);
			resultado = "Se ha eliminado al redactor " + nombreBusc + ", con DNI " + dniBusc + ", del sistema.";
		}
		return resultado;
	}

	public static String enterNewsRedac() {

		String resultado = "", dniBusc = "", nombreEnc = "", tipo = "", competition = "", club = "", player = "",
				tenista = "", team = "";
		int posArrayRedac = 0, opcion = 0;
		System.out.println("Introduzca el DNI del redactor al que añadir la noticia.");
		dniBusc = entrada.nextLine();
		posArrayRedac = findRedacDni(dniBusc);
		if (posArrayRedac == -1) {
			resultado = "No se ha encontrado en el sistema, el redactor indicado.";
		} else {
			nombreEnc = redactors.get(posArrayRedac).getNombre();
			System.out.println("Que tipo de noticia quiere añadir al redactor " + nombreEnc + "\n" + "1. Futbol. \n"
					+ "2. Basquet. \n" + "3. Tenis. \n" + "4. F1. \n" + "5. Moto");
			opcion = entrada.nextInt();
			entrada.nextLine();
			System.out.println("Introduzca el titular de la noticia");
			String headline = entrada.nextLine();
			switch (opcion) {
			case 1:
				System.out.println("Introduzca la competicion");
				competition = entrada.nextLine();
				System.out.println("Introduzca el club");
				club = entrada.nextLine();
				System.out.println("Introduzca el jugador");
				player = entrada.nextLine();
				NoticiaFutbol noticiaFutbol = new NoticiaFutbol(headline, competition, club, player);
				redactors.get(posArrayRedac).getNoticias().add(noticiaFutbol);
				tipo = "futbol";
				break;
			case 2:
				System.out.println("Introduzca la competicion");
				competition = entrada.nextLine();
				System.out.println("Introduzca el club");
				club = entrada.nextLine();
				NoticiaBasquet noticiaBasquet = new NoticiaBasquet(headline, competition, club);
				redactors.get(posArrayRedac).getNoticias().add(noticiaBasquet);
				tipo = "basquet";
				break;
			case 3:
				System.out.println("Introduzca la competicion");
				competition = entrada.nextLine();
				System.out.println("Introduzca el tenista");
				tenista = entrada.nextLine();
				NoticiaTenis noticiaTenis = new NoticiaTenis(headline, competition, tenista);
				redactors.get(posArrayRedac).getNoticias().add(noticiaTenis);
				tipo = "tenis";
				break;
			case 4:
				System.out.println("Introduzca la escuderia");
				team = entrada.nextLine();
				NoticiaF1 noticiaF1 = new NoticiaF1(headline, team);
				redactors.get(posArrayRedac).getNoticias().add(noticiaF1);
				tipo = "formula 1";
				break;
			case 5:
				System.out.println("Introduzca el equipo");
				team = entrada.nextLine();
				NoticiaMoto noticiaMoto = new NoticiaMoto(headline, team);
				redactors.get(posArrayRedac).getNoticias().add(noticiaMoto);
				tipo = "motociclismo";
				break;
			default:
				System.out.println("ERROR. Esta opción no está disponible.");
				break;
			}
			resultado = "Se ha introducido la noticia de " + tipo + " al redactor " + nombreEnc + " con DNI " + dniBusc;
		}
		return resultado;
	}

	public static String removeNewsRedac() {

		String resultado = "", dniBusc = "", titularInd = "";
		Redactor redacEnc;
		int posArrayRedac = 0, posArrayNot = 0;
		System.out.println("Introduzca el DNI del redactor al que eliminar la noticia.");
		dniBusc = entrada.nextLine();
		posArrayRedac = findRedacDni(dniBusc);
		if (posArrayRedac == -1) {
			resultado = "No se ha encontrado en el sistema, el redactor indicado.";
		} else {
			redacEnc = redactors.get(posArrayRedac);
			if (redacEnc.getNoticias().size() == 0) {
				resultado = "El redactor indicado no tiene noticias introducidas.";
			} else {
				System.out.println("De los siguientes titulares, indique el que quiere borrar: ");
				for (Noticia noticia : redacEnc.getNoticias()) {
					System.out.println(noticia.getHeadline());
				}
				titularInd = entrada.nextLine();
				posArrayNot = redacEnc.findNewsRedac(titularInd);
				if (posArrayNot == -1) {
					resultado = "Ese titular no figura entre las noticias del redactor " + redacEnc;
				} else {
					redacEnc.getNoticias().remove(posArrayNot);
					resultado = "Se ha eliminado la noticia " + titularInd + " del redactor " + redacEnc;
				}
			}
		}
		return resultado;
	}

	public static String showNewsRedac() {
		// OPCION BUSCADOR POR POSICION ARRAYLIST
		/*
		 * String resultado = "", dniBusc = ""; Redactor redacEnc; int posArrayRedac =
		 * 0; System.out.
		 * println("Introduzca el DNI del redactor del que quiere ver las noticias");
		 * dniBusc = entrada.nextLine(); posArrayRedac = findRedacDni(dniBusc); if
		 * (posArrayRedac == -1) { resultado =
		 * "No se ha encontrado en el sistema, el redactor indicado."; } else { redacEnc
		 * = redactors.get(posArrayRedac); if (redacEnc.getNoticias().size() == 0) {
		 * resultado = "El redactor indicado no tiene noticias introducidas."; } else {
		 * for (Noticia noticia : redacEnc.getNoticias()) { resultado +=
		 * noticia.toString(); } } } return resultado; }
		 */
		// OPCION BUSCADOR POR OBJETO
		String resultado = "", dniBusc = "";
		Redactor redacEnc;

		System.out.println("Introduzca el DNI del redactor del que quiere ver las noticias");
		dniBusc = entrada.nextLine();
		redacEnc = findRedac(dniBusc);
		if (redacEnc != null) {
			if (redacEnc.getNoticias().size() == 0) {
				resultado = "El redactor indicado no tiene noticias introducidas.";
			} else {
				for (Noticia noticia : redacEnc.getNoticias()) {
					resultado += noticia.toString();
				}
			}
		} else {
			resultado = "No se ha encontrado en el sistema, el redactor indicado.";
		}
		return resultado;
	}

	public static String calcScoreNews() {

		String resultado = "", dniBusc = "", titularInd = "";
		Redactor redacEnc;
		Noticia noticiaEnc;
		int posArrayRedac = 0, posArrayNot = 0, score = 0;
		System.out.println("Introduzca el DNI del redactor del que quiere calcular la noticia.");
		dniBusc = entrada.nextLine();
		posArrayRedac = findRedacDni(dniBusc);
		if (posArrayRedac == -1) {
			resultado = "No se ha encontrado en el sistema, el redactor indicado.";
		} else {
			redacEnc = redactors.get(posArrayRedac);
			if (redacEnc.getNoticias().size() == 0) {
				resultado = "El redactor indicado no tiene noticias introducidas.";
			} else {
				System.out.println(
						"De las siguientes noticias del redactor.\nIndique el titular de la que quiere saber la puntuacion: ");
				for (Noticia noticia : redacEnc.getNoticias()) {
					System.out.println(noticia.getHeadline());
				}
				titularInd = entrada.nextLine();
				posArrayNot = redacEnc.findNewsRedac(titularInd);
				if (posArrayNot == -1) {
					resultado = "Ese titular no figura entre las noticias del redactor " + redacEnc;
				} else {
					noticiaEnc = redacEnc.getNoticias().get(posArrayNot);
					score = noticiaEnc.calcScoreNews();
					resultado = "La puntuacion de la noticia " + titularInd + " es " + score + " puntos.";
				}
			}
		}
		return resultado;
	}

	public static String calcPriceNews() {

		String resultado = "", dniBusc = "", titularInd = "";
		Redactor redacEnc;
		Noticia noticiaEnc;
		int posArrayRedac = 0, posArrayNot = 0, price = 0;
		System.out.println("Introduzca el DNI del redactor del que quiere calcular la noticia.");
		dniBusc = entrada.nextLine();
		posArrayRedac = findRedacDni(dniBusc);
		if (posArrayRedac == -1) {
			resultado = "No se ha encontrado en el sistema, el redactor indicado.";
		} else {
			redacEnc = redactors.get(posArrayRedac);
			if (redacEnc.getNoticias().size() == 0) {
				resultado = "El redactor indicado no tiene noticias introducidas.";
			} else {
				System.out.println(
						"De las siguientes noticias del redactor.\nIndique el titular de la que quiere saber el precio: ");
				for (Noticia noticia : redacEnc.getNoticias()) {
					System.out.println(noticia.getHeadline());
				}
				titularInd = entrada.nextLine();
				posArrayNot = redacEnc.findNewsRedac(titularInd);
				if (posArrayNot == -1) {
					resultado = "Ese titular no figura entre las noticias del redactor " + redacEnc;
				} else {
					noticiaEnc = redacEnc.getNoticias().get(posArrayNot);
					price = noticiaEnc.calcPriceNews();
					resultado = "El precio de la noticia " + titularInd + " es " + price + " euros.";
				}
			}
		}
		return resultado;
	}

	// METODOS AUXILIARES (BUSCADORES)

	public static int findRedacNombre(String nombre) {

		int arrayPosition = 0;
		boolean stop = false;
		for (int i = 0; i < redactors.size() && stop == false; i++) {
			if (nombre.equalsIgnoreCase(redactors.get(i).getNombre())) {
				stop = true;
				arrayPosition = i;
			} else {
				arrayPosition = -1;
			}
		}
		return arrayPosition;
	}

	public static int findRedacDni(String dni) {
		int arrayPosition = 0;
		boolean stop = false;
		if (redactors.size() != 0) {
			for (int i = 0; i < redactors.size() && stop == false; i++) {
				if (dni.equalsIgnoreCase(redactors.get(i).getDni())) {
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

	public static Redactor findRedac(String dni) {

		Redactor RedactorEnc = null;
		boolean stop = false;
		if (redactors.size() != 0) {
			for (int i = 0; i < redactors.size() && stop == false; i++) {
				if (dni.equalsIgnoreCase(redactors.get(i).getDni())) {
					stop = true;
					RedactorEnc = redactors.get(i);
				} else {
					RedactorEnc = null;
				}
			}
		} else {
			RedactorEnc = null;
		}
		return RedactorEnc;
	}

}
