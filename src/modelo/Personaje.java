package modelo;

import processing.core.PApplet;
import processing.core.PConstants;

public class Personaje extends Objeto implements Runnable {

	public static int STEP = 5;
	private int puntaje;
	private int RAD = 10;

	public Personaje(int id, int direccion, int posInicialX, int posInicialY, PApplet sketch) {
		super(id, direccion, posInicialX, posInicialY, posInicialX, posInicialY, sketch);
	}

	@Override
	public void mover() {
		switch (getDireccion()) {
		case PConstants.UP:
			setPosY(getPosY() - STEP);
			break;
		case PConstants.DOWN:
			setPosY(getPosY() + STEP);
			break;
		case PConstants.LEFT:
			setPosX(getPosX() - STEP);
			break;
		case PConstants.RIGHT:
			setPosX(getPosX() + STEP);
			break;
		}
	}

	@Override
	public void run() {
		sketch.fill(104, 191, 222);
		sketch.circle(getPosX(), getPosY(), RAD);
	}

}
