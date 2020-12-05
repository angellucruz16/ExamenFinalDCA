package vista;

import controlador.MainController;
import processing.core.PApplet;

public class MainView  extends PApplet {

	public static void main(String[] args) {
		String[] processingArgs = {"MainView"};
		MainView myView = new MainView();
		PApplet.runSketch(processingArgs, myView);
	}
	
	MainController controlador;
	
	@Override
	public void draw() {
		background(255);
		this.fill(GRAY);
		this.rect(0, 70, 1200, 100);
		this.rect(0, 270, 1200, 100);
		this.rect(0, 470, 1200, 100);
		this.rect(0, 670, 1200, 100);

	}
	
	@Override
	public void settings() {
		size(1200,800);
		controlador = new MainController(this);
	}
	
	@Override
	public void setup() {
		noStroke();
		frameRate(80);
		ellipseMode(RADIUS);
	}

}
