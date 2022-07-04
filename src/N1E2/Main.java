package N1E2;

/*
* Crea una classe "Cotxe" amb els atributs: marca, model i potència. 
* La marca ha de ser estàtic final, el model estàtic i la potència final. 
* Demostra la diferència entre els tres. N’hi ha algun que es pugui inicialitzar al constructor de la classe?
* Afegeix dos mètodes a la classe "Cotxe". Un mètode estàtic anomenat frenar() i un altre no estàtic anomenat accelerar(). 
* El mètode accelerar ha de mostrar per consola: “El vehicle està accelerant” i el mètode frenar() ha de mostrar: “El vehicle està frenant”. 
* Demostra com invocar el mètode estàtic i el no estàtic des del main() de la classe principal.
*/

public class Main {

	public static void main(String[] args) {
		//data
		String result = "";
		//objects
		Coche coche1 = new Coche();
		// se crea un coche con modelo null y potencia 125.
		coche1.setModelo("Kuga");
		// cambio el parametro modelo de null a Kuga (de todos los objetos Coche) desde el objeto coche1. Aunque IDE me envia un warning, se puede hacer.
		System.out.println(coche1.toString());
		Coche.setModelo("Focus");
		// cambio el parametro modelo de Kuga a Focus (de todos los objetos Coche) desde la clase Coche.
		System.out.println(coche1.toString());
		Coche coche2 = new Coche("Fiesta", 80); 
		/* modifica el atributo modelo en todos los objetos de clase Coche.(del coche1 se ha cambiado de Kuga a Fiesta)
		  introduce el valor de potencia, y no se podrá modificar en este objeto.*/
		 
		System.out.println(coche2);
		System.out.println(coche1);
		
		//methods/output
		result = coche1.frenar();	//invocado desde el objeto coche1.
		System.out.println(result);
		result = coche2.frenar();	//invocado desde el objeto coche2.
		System.out.println(result);
		result = coche1.acelerar();	//invocado desde el objeto coche1. Warning desde IDE.
		System.out.println(result);
		result = Coche.acelerar();	//invocado desde la clase Coche.
		System.out.println(result);

	}
}
