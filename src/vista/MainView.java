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
		if (controlador.getEstado() == controlador.JUGANDO) {
			img = loadImage("./background.png");
			img.loadPixels();
			background(img);
			for (Carro carro : controlador.getCarros()) {
				carro.run();
			}
			controlador.getPersonaje().run();
			this.fill(0);
			this.textFont(createFont("DejaVu Sans", 25));
			this.text(controlador.getPartidaActual().setDuracion(), 200, 75);
		}
		if (controlador.getEstado() == controlador.PERDIO) {
			img = loadImage("./perdiste.png");
			img.loadPixels();
			background(img);
		}
		if (controlador.getEstado() == controlador.GANO) {
			img = loadImage("./gano.png");
			img.loadPixels();
			background(img);
		}
		if (controlador.getEstado() == controlador.VERDATOS) {
			img = loadImage("./datos.png");
			img.loadPixels();
			background(img);
			if (controlador.mostrarLista()) {
				this.fill(0);
				this.textFont(createFont("DejaVu Sans", 25));
				this.text("PARTIDAS JUGADAS", 800, 75);
				this.textFont(createFont("DejaVu Sans", 15));

				this.text(controlador.getListaPartidas(), 800, 150);
			}

		}
	}

	@Override
	public void keyPressed() {
		if (key == CODED) {
			controlador.moverPersonaje(keyCode);
		}
	}

	@Override
	public void mouseClicked() {

		if (controlador.getEstado() == controlador.PERDIO) {
			if (mouseX > 435 && mouseX < 765 && mouseY > 535 && mouseY < 620) {
				controlador.reiniciar();
			}
		}
		if (controlador.getEstado() == controlador.GANO) {
			if (mouseX > 250 && mouseX < 580 && mouseY > 540 && mouseY < 630) {
				controlador.reiniciar();
			}
			if (mouseX > 620 && mouseX < 950 && mouseY > 540 && mouseY < 630) {
				controlador.mostrarDatos();
			}
		}
		if (controlador.getEstado() == controlador.VERDATOS) {
			if (mouseX > 100 && mouseX < 320 && mouseY > 265 && mouseY < 325) {
				controlador.ordenarPorFechaHora();
			}
			if (mouseX > 345 && mouseX < 570 && mouseY > 265 && mouseY < 325) {
				controlador.ordenarPorDuracion();
			}
			if (mouseX > 780 && mouseX < 1120 && mouseY > 630 && mouseY < 715) {
				controlador.reiniciar();
			}
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
