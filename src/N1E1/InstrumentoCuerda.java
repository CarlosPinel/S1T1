package N1E1;

public class InstrumentoCuerda extends Instrumento {
		
//	Constructor
	public InstrumentoCuerda() { super(); }
	public InstrumentoCuerda(String nombre, double precio) {
		super(nombre, precio);
	}
	
//	Methods generals
	public String tocar() {
		return "Está sonando un instrumento de cuerda";
	}
	
	@Override
	public String toString() {
		return "Instrumento [nombre=" + super.getNombre() + ", precio=" + super.getPrecio() + "]";	}
}

