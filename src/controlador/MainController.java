package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import modelo.Carro;
import modelo.Partida;
import modelo.Personaje;
import processing.core.PApplet;

public class MainController {

	public static int JUGANDO = 1;
	public static int PERDIO = 2;
	public static int GANO = 3;
	public static int VERDATOS = 4;

	private PApplet sketch;

	private ArrayList<Carro> carros;
	private ArrayList<Partida> partidas;
	private Personaje personaje;
	private int estado;
	private Partida partidaActual;
	private boolean mostrarDatos;

	public MainController(PApplet sketch) {
		this.sketch = sketch;
		carros = new ArrayList<Carro>();
		partidas = new ArrayList<Partida>();
		try {
			leerDatos();
		} catch (IOException e) {
			System.out.println("No fue posible leer los datos iniciales");
		}

		partidaActual = new Partida(1, new Date());
		estado = JUGANDO;
	}

	public void burbuja() {
		Partida temp;
		for (int i = 1; i < partidas.size(); i++) {
			for (int j = 0; j < partidas.size() - 1; j++) {
				if (partidas.get(j).getDuracion() > partidas.get(j + 1).getDuracion()) {
					temp = partidas.get(j);
					partidas.set(j, partidas.get(j + 1));
					partidas.set(j + 1, temp);
				}
			}
		}
	}

	public void ganar() {
		estado = GANO;
		partidas.add(partidaActual);
	}

	public ArrayList<Carro> getCarros() {
		return carros;
	}

	public int getEstado() {
		return estado;
	}

	public String getListaPartidas() {
		String lista = "";
		int id = 1;
		for (Partida partida : partidas) {
			lista += "Partida #: " + partida.getId() + "\nFecha y hora: " + partida.getFechaHora() + "\nDuración: "
					+ partida.getDuracion() + "\n";
			id++;
		}
		return lista;
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
		int contador = 0;
		while ((linea = reader.readLine()) != null) {
			String[] datos = linea.split(",");

			if (datos[0].equals("personaje")) {
				personaje = new Personaje(contador, 1, Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), sketch,
						this);
			} else {
				Carro carro = new Carro(contador, Integer.parseInt(datos[1]), Integer.parseInt(datos[2]),
						Integer.parseInt(datos[3]), sketch, this);
				carros.add(carro);
			}
			contador++;
		}
	}

	public void mostrarDatos() {
		estado = VERDATOS;
	}

	public boolean mostrarLista() {
		return mostrarDatos;
	}

	public void moverPersonaje(int keyCode) {
		personaje.setDireccion(keyCode);
		personaje.mover();
	}

	public void ordenarPorDuracion() {
		burbuja();
		mostrarDatos = true;
	}

	public void ordenarPorFechaHora() {
		Collections.sort(partidas);
		mostrarDatos = true;
	}

	public void perder() {
		estado = PERDIO;
		partidas.add(partidaActual);
	}

	public void reiniciar() {
		personaje.setPosX(personaje.getPosInicialX());
		personaje.setPosY(personaje.getPosInicialY());
		for (Carro carro : carros) {
			carro.setPosX(carro.getPosInicialX());
			carro.setPosY(carro.getPosInicialY());
		}
		partidaActual = new Partida(partidas.size() + 1, new Date());
		estado = JUGANDO;
	}

}
