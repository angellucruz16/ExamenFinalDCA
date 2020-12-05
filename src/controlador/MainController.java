package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.*;
import processing.core.PApplet;

public class MainController {
	
	private PApplet app;
	
	private ArrayList<Carro> carros;
	private ArrayList<Partida> partidas;
	private Personaje personaje;

	public MainController(PApplet app) {
		carros = new ArrayList<Carro>();
		partidas = new ArrayList<Partida>();
		try {
			leerDatos();
		} catch (IOException e) {
			System.out.println("No fue posible leer los datos iniciales");
		}
	}
	
	public void leerDatos() throws IOException {
		File file = new File("./datos.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linea = "";
		while((linea = reader.readLine()) != null) {
			String[] datos = linea.split(",");
			
			if(datos[0]=="personaje") {
				personaje = new Personaje(0, 1, Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
			} else {
				Carro carro = new Carro(1, Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3]));
				carros.add(carro);
			}
		}
	}
}
