package Munchkin;

public class Maldicion extends Carta implements IEfectoCarta {

	
	// tipo de maldicion
	enum TipoMaldicion {
		QUITANIVELES,
		QUITATESOROS
	}
	
	// Atributos
	
	protected TipoMaldicion tipo;
	protected String descripcion;
	protected int potencia;
	
	// Getter & Setter
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	// Constructor 
	
	public Maldicion(String nombre, String tipo, String descripcion, int potencia) {
		super(nombre);
		this.tipo = tipo == "QUITANIVELES" ? TipoMaldicion.QUITANIVELES: TipoMaldicion.QUITATESOROS;
		this.descripcion = descripcion;
		this.potencia = potencia;
	}

	// Métodos
	
	@Override
	public void aplicarEfecto(Jugador jugador, Juego juego) {
		// TODO
		ejecutar(jugador, juego);
	}

	@Override
	public void ejecutar(Jugador jugador, Juego juego) {
		if (this.tipo == TipoMaldicion.QUITANIVELES) {
			jugador.bajarNivel(potencia);
			System.out.println("¡MALDICION!");
			System.out.println("¡Has perdido "+ potencia + " niveles!");
		} else if (this.tipo == TipoMaldicion.QUITATESOROS) {
			System.out.println("¡MALDICION!");
			System.out.println("Vas a perder " + potencia + " tesoros");
			boolean intentoRobar = true;
			int quedanPorRobar = this.potencia;
			int tesorosRobados = 0;
			while (tesorosRobados < quedanPorRobar && intentoRobar == true) {
				intentoRobar = jugador.removerTesoroAleatorio();
				if (intentoRobar) {
					tesorosRobados += 1;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Maldicion [tipo=" + tipo + ", descripcion=" + descripcion + ", potencia=" + potencia + "]";
	}
}
