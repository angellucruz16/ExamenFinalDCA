package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import modelo.Carro;
import modelo.Partida;
import modelo.Personaje;
import processing.core.PApplet;

public class MainController {

	public static int JUGANDO = 1;
	private PApplet sketch;

	private ArrayList<Carro> carros;
	private ArrayList<Partida> partidas;
	private Personaje personaje;
	private int estado;
	private Partida partidaActual;

	public MainController(PApplet sketch) {
		this.sketch = sketch;
		carros = new ArrayList<Carro>();
		partidas = new ArrayList<Partida>();
		try {
			leerDatos();
		} catch (IOException e) {
			System.out.println("No fue posible leer los datos iniciales");
		}

		partidaActual = new Partida(new Date());
		estado = JUGANDO;
	}

	public ArrayList<Carro> getCarros() {
		return carros;
	}

	public int getEstado() {
		return estado;
	}

	public Partida getPartidaActual() {
		return partidaActual;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void leerDatos() throws IOException {
		File file = new File("./datos.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linea = "";
		while ((linea = reader.readLine()) != null) {
			String[] datos = linea.split(",");

			if (datos[0].equals("personaje")) {
				personaje = new Personaje(0, 1, Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), sketch);
			} else {
				Carro carro = new Carro(1, Integer.parseInt(datos[1]), Integer.parseInt(datos[2]),
						Integer.parseInt(datos[3]), sketch);
				carros.add(carro);
			}
		}
	}

	public void moverPersonaje(int keyCode) {
		personaje.setDireccion(keyCode);
		personaje.mover();
	}

}
