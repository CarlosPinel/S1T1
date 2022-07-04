package N1E1;

public class InstrumentoViento extends Instrumento {

//	Constructor
	public InstrumentoViento() {super();}
	public InstrumentoViento(String nombre, double precio) {
		super(nombre, precio);
	}

//	Methods generals
	public String tocar() {
		return "Está sonando un instrumento de viento";
	}

	@Override
	public String toString() {
		return "Instrumento [nombre=" + super.getNombre() + ", precio=" + super.getPrecio() + "]";
	}
}
