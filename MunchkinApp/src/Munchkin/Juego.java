package Munchkin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Juego {

	protected ArrayList<Jugador> jugadores;
	protected Mazo mazoPuerta;
	protected Mazo mazoTesoro;
	protected int turno;
	private boolean terminado;
	
	Scanner scan = new Scanner(System.in);

	public Juego (ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.mazoPuerta = new Mazo();
		this.mazoTesoro = new Mazo();
		this.turno = 0;
		this.terminado = false;
		
		inicializarCartas(mazoPuerta, mazoTesoro);
	}
	
	public Juego(ArrayList<Jugador> jugadores, Mazo mazoPuerta, Mazo mazoTesoro, int turno, boolean terminado) {
		this.jugadores = jugadores;
		this.mazoPuerta = mazoPuerta;
		this.mazoTesoro = mazoTesoro;
		this.turno = turno;
		this.terminado = terminado;
	}

	public Juego() {
		super();
		this.jugadores = null;
		this.mazoPuerta = null;
		this.mazoTesoro = null;
		this.turno = 1;
		this.terminado = false;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Mazo getMazoPuerta() {
		return mazoPuerta;
	}

	public void setMazoPuerta(Mazo mazoPuerta) {
		this.mazoPuerta = mazoPuerta;
	}

	public Mazo getMazoTesoro() {
		return mazoTesoro;
	}

	public void setMazoTesoro(Mazo mazoTesoro) {
		this.mazoTesoro = mazoTesoro;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public boolean isTerminado() {
		return terminado;
	}

	public void setTerminado(boolean terminado) {
		this.terminado = terminado;
	}

	public void inicializarCartas(Mazo mazoPuertas, Mazo mazoTesoros) {

		// Armas
		Tesoro martillo = new Tesoro("Martillos", TipoTesoro.ARMA, 4);
		Tesoro espadaLarga = new Tesoro("Espada Larga", TipoTesoro.ARMA, 5);
		Tesoro hachaDeGuerra = new Tesoro("Hacha de Guerra", TipoTesoro.ARMA, 6);
		Tesoro daga = new Tesoro("Daga", TipoTesoro.ARMA, 2);
		Tesoro mangualDeLaMuerte = new Tesoro("Mangual de la Muerte", TipoTesoro.ARMA, 7);
		Tesoro arcoLargo = new Tesoro("Arco Largo", TipoTesoro.ARMA, 4);
		Tesoro lanzaFiluda = new Tesoro("Lanza Filuda", TipoTesoro.ARMA, 3);
		Tesoro espadaFlamigera = new Tesoro("Espada Flamígera", TipoTesoro.ARMA, 8);

		// Armaduras
		Tesoro armaduraDeCuero = new Tesoro("Armadura de Cuero", TipoTesoro.ARMADURA, 3);
		Tesoro cotaDeMalla = new Tesoro("Cota de Malla", TipoTesoro.ARMADURA, 5);
		Tesoro armaduraCompleta = new Tesoro("Armadura Completa", TipoTesoro.ARMADURA, 6);
		Tesoro escudoDeMadera = new Tesoro("Escudo de Madera", TipoTesoro.ARMADURA, 2);
		Tesoro armaduraMagica = new Tesoro("Armadura Mágica", TipoTesoro.ARMADURA, 7);
		Tesoro yelmoReforzado = new Tesoro("Yelmo Reforzado", TipoTesoro.ARMADURA, 4);

		// Accesorios
		Tesoro botasVeloces = new Tesoro("Botas Veloces", TipoTesoro.ACCESORIO, 3);
		Tesoro anilloDeFuerza = new Tesoro("Anillo de Fuerza", TipoTesoro.ACCESORIO, 4);
		Tesoro capaDeLevitacion = new Tesoro("Capas de Levitación", TipoTesoro.ACCESORIO, 5);
		Tesoro amuletoProtector = new Tesoro("Amuleto Protector", TipoTesoro.ACCESORIO, 3);
		Tesoro guantesDelLadron = new Tesoro("Guantes del Ladrón", TipoTesoro.ACCESORIO, 2);
		Tesoro cinturonDelCampeon = new Tesoro("Cinturón del Campeón", TipoTesoro.ACCESORIO, 6);
		Tesoro pocionCurativa = new Tesoro("Poción Curativa", TipoTesoro.ACCESORIO, 1);

		// monstruos
		Monstruo rataGigante = new Monstruo("Rata Gigante", 1, 1, 1);
		Monstruo goblinLadron = new Monstruo("Goblin Ladrón", 2, 1, 1);
		Monstruo esqueletoArmado = new Monstruo("Esqueleto Armado", 3, 1, 2);
		Monstruo orcoGuerrero = new Monstruo("Orco Guerrero", 4, 1, 2);
		Monstruo arañaVenenosa = new Monstruo("Araña Venenosa", 3, 1, 1);
		Monstruo zombiHambriento = new Monstruo("Zombi Hambriento", 4, 1, 2);
		Monstruo trasgoPeleon = new Monstruo("Trasgo Peleón", 2, 1, 1);
		Monstruo loboSalvaje = new Monstruo("Lobo Salvaje", 3, 1, 1);
		Monstruo vampiroNocturno = new Monstruo("Vampiro Nocturno", 6, 2, 3);
		Monstruo trollDeMontaña = new Monstruo("Troll de Montaña", 7, 2, 3);
		Monstruo dragonJoven = new Monstruo("Dragón Joven", 8, 2, 4);
		Monstruo licantropoFeroz = new Monstruo("Licantropo Feroz", 5, 1, 2);
		Monstruo golemDePiedra = new Monstruo("Golem de Piedra", 6, 2, 2);
		Monstruo espectroMaldito = new Monstruo("Espectro Maldito", 1, 1, 3);
		Monstruo hidraMulticabeza = new Monstruo("Hidra Multicabeza", 1, 2, 4);
		Monstruo demonioInfernal = new Monstruo("Demonio Infernal", 1, 2, 5);
		Monstruo minotauroSalvaje = new Monstruo("Minotauro Salvaje", 2, 2, 3);
		Monstruo basiliscoLetal = new Monstruo("Basilisco Letal", 1, 2, 3);
		Monstruo necromante = new Monstruo("Necromante", 1, 2, 3);
		Monstruo dragonAnciano = new Monstruo("Dragón Anciano", 2, 3, 6);
		Monstruo kraken = new Monstruo("Kraken", 1, 2, 5);

		// Maldiciones
		Maldicion malaDeSuerte = new Maldicion("Mala de Suerte", "QUITANIVELES", "Pierdes 1 nivel", 1);
		Maldicion maldicionDelLadron = new Maldicion("Maldición del Ladrón", "QUITATESORO", "Pierdes 2 tesoros al azar",
				2);
		Maldicion amnesia = new Maldicion("Amnesia", "QUITANIVELES", "Pierdes 2 niveles", 2);
		Maldicion pobreza = new Maldicion("Pobreza", "QUITATESORO", "Pierdes 1 tesoro", 1);
		Maldicion robo = new Maldicion("Robo", "QUITATESORO", "Te roban 1 tesoros", 1);
		Maldicion caos = new Maldicion("Caos", "QUITANIVELES", "Pierdes 1 niveles", 1);
		Maldicion malaFortuna = new Maldicion("Mala Fortuna", "QUITATESORO", "Pierdes 1 tesoro al azar", 1);
		Maldicion decadencia = new Maldicion("Decadencia", "QUITANIVELES", "Pierdes 1 niveles", 1);
		Maldicion saqueo = new Maldicion("Saqueo", "QUITATESORO", "Pierdes 1 tesoros", 1);
		Maldicion retroceso = new Maldicion("Retroceso", "QUITANIVELES", "Retrocedes 1 niveles", 1);
		/*Maldicion perdidaTotal = new Maldicion("Perdida Total", "QUITATESORO", "Pierdes 6 tesoros", 6);
		Maldicion desgracia = new Maldicion("Desgracia", "QUITANIVELES", "Pierdes 2 niveles", 2);
		Maldicion ratero = new Maldicion("Ratero", "QUITATESORO", "Te roban 1 tesoro", 1);
		Maldicion incompetencia = new Maldicion("Incompetencia", "QUITANIVELES", "Pierdes 1 nivel", 1);
		Maldicion bancarrota = new Maldicion("Bancarrota", "QUITATESORO", "Pierdes 3 tesoros", 3);
		Maldicion regresion = new Maldicion("Regresión", "QUITANIVELES", "Pierdes 3 niveles", 3);
		Maldicion desposesion = new Maldicion("Desposesión", "QUITATESORO", "Pierdes 2 tesoros", 2);
		Maldicion humillacion = new Maldicion("Humillación", "QUITANIVELES", "Pierdes 4 niveles", 4);
		Maldicion expolio = new Maldicion("Expolio", "QUITATESORO", "Pierdes 5 tesoros", 5);
		Maldicion pesadilla = new Maldicion("Pesadilla", "QUITANIVELES", "Retrocedes al nivel 1", 10);
		Maldicion ruina = new Maldicion("Ruina", "QUITATESORO", "Pierdes todos tus tesoros", 10);*/
		
		// Añadir tesoros al mazoTesoros
		mazoTesoros.cartas.addAll(Arrays.asList(
		    martillo, espadaLarga, hachaDeGuerra, daga, mangualDeLaMuerte,
		    arcoLargo, lanzaFiluda, espadaFlamigera,
		    armaduraDeCuero, cotaDeMalla, armaduraCompleta, escudoDeMadera,
		    armaduraMagica, yelmoReforzado,
		    botasVeloces, anilloDeFuerza, capaDeLevitacion, amuletoProtector,
		    guantesDelLadron, cinturonDelCampeon, pocionCurativa
		));

		// Añadir monstruos al mazoPuertas
		mazoPuertas.cartas.addAll(Arrays.asList(
		    rataGigante, goblinLadron, esqueletoArmado, orcoGuerrero, arañaVenenosa,
		    zombiHambriento, trasgoPeleon, loboSalvaje, vampiroNocturno,
		    trollDeMontaña, dragonJoven, licantropoFeroz, golemDePiedra,
		    espectroMaldito, hidraMulticabeza, demonioInfernal, minotauroSalvaje,
		    basiliscoLetal, necromante, dragonAnciano, kraken
		));

		// Añadir maldiciones al mazoPuertas
		mazoPuertas.cartas.addAll(Arrays.asList(
		    malaDeSuerte, maldicionDelLadron, amnesia, pobreza, robo, caos,
		    malaFortuna, decadencia, saqueo, retroceso /*,perdidaTotal, desgracia,
		    ratero, incompetencia, bancarrota, regresion, desposesion,
		    humillacion, expolio, pesadilla, ruina*/
		));
		
		//Barajamos las barajas
		Collections.shuffle(mazoPuertas.cartas);
		Collections.shuffle(mazoTesoros.cartas);

	}

	public Carta robarPuerta() {
		return mazoPuerta.robar();
	}

	public Carta robarTesoro() {
		return mazoTesoro.robar();
	}

	public void jugar() {

		while (!terminado) {
			

			if (turno == jugadores.size()) {
				turno = 0;
			}
			
			Jugador actual = jugadores.get(turno);
			System.out.println("======================================");
			System.out.println("Turno del jugador: " + actual.toString());
			System.out.println("======================================");

			turno(actual);
			
			if (actual.getNivel() >= 5) {
				System.out.println("El jugador " + actual.getNombre() + " HA GANADO!!!");
				terminado = true;
			} else if (this.mazoPuerta.estaVacio() || this.mazoTesoro.estaVacio()) {
				System.out.println("La partida ha acabado en empate!");
				terminado = true;
			} else {
				scan.nextLine();
				turno++;
			}
		}
	}

	public void turno(Jugador jugador) {

		Carta carta = robarPuerta();

		if (carta instanceof Monstruo) {
			((Monstruo) carta).ejecutar(jugador, this);
		} else if (carta instanceof Maldicion) {
			((Maldicion) carta).aplicarEfecto(jugador, this);
		} else if (carta instanceof Tesoro) {
			((Tesoro) carta).aplicarEfecto(jugador, this);
		} else {
			turno++;
		}
		
		Random random = new Random();
		int puedeRobar = random.nextInt(3);
		System.out.println("The result of You can steal: " + puedeRobar);

		if (puedeRobar == 0) {
			// roba
			System.out.println("Intentemos robar una maravilla por aqui");
			// define quien robar
			int indiceVictima = random.nextInt(this.jugadores.size());
			Jugador victima = this.jugadores.get(indiceVictima);
			while(victima == jugador) {
				indiceVictima = random.nextInt(this.jugadores.size());
				victima = this.jugadores.get(indiceVictima);
			}
			System.out.println(victima.getNombre() + ", da me algo y con prisa !");
			Tesoro tesoro = jugador.robarTesoro(victima);
			System.out.println("Gracias por este " + tesoro.getNombre());
			if (tesoro.tipo != TipoTesoro.INUTIL) {
				jugador.recibirTesoro(tesoro);
			}

		}

	}

}
