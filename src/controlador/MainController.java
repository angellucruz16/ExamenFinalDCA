package controlador;

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
	}
}
