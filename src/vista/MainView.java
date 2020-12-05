package vista;

import controlador.MainController;
import modelo.Carro;
import processing.core.PApplet;
import processing.core.PImage;

public class MainView extends PApplet {

	public static void main(String[] args) {
		String[] processingArgs = { "MainView" };
		MainView myView = new MainView();
		PApplet.runSketch(processingArgs, myView);
	}

	PImage img;

	MainController controlador;

	@Override
	public void draw() {
		// background(255);
		img.loadPixels();
		if (controlador.getEstado() == controlador.JUGANDO) {
			background(img);
			for (Carro carro : controlador.getCarros()) {
				carro.run();
			}
			controlador.getPersonaje().run();
			this.fill(0);
			this.textFont(createFont("DejaVu Sans", 25));
			this.text(controlador.getPartidaActual().setDuracion(), 200, 75);
		}
	}

	@Override
	public void keyPressed() {
		if (key == CODED) {
			controlador.moverPersonaje(keyCode);
		}
	}

	@Override
	public void settings() {
		controlador = new MainController(this);
		img = loadImage("./background.png");
		size(img.width, img.height);
	}

	@Override
	public void setup() {
		noStroke();
		frameRate(80);
		ellipseMode(RADIUS);
		img = loadImage("./background.png");
		img.loadPixels();
	}

}
