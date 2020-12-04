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
