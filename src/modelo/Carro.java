package modelo;

import java.util.Random;

import controlador.MainController;
import processing.core.PApplet;

public class Carro extends Objeto implements Runnable {

	public static int MOVER = 30;
	public static int PASO = 20;
	private int direccion;
	private int count;
	private int color;
	private Random random;

	public Carro(int id, int direccion, int posInicialX, int posInicialY, PApplet sketch, MainController controlador) {
		super(id, direccion, posInicialX, posInicialY, posInicialX, posInicialY, sketch, controlador);
		count = 0;
		random = new Random();
		color = random.nextInt(5) + 1;
	}

	@Override
	public void mover() {
		if (count == MOVER) {
			if (getDireccion() == 1) {
				setPosX(getPosX() + PASO);
				if (sketch.width <= getPosX()) {
					color = random.nextInt(5) + 1;
					setPosX(0);
				}
			} else {
				setPosX(getPosX() - PASO);
				count = 0;
				if (0 >= getPosX()) {
					setPosX(sketch.width);
					color = random.nextInt(5) + 1;
				}
			}
			count = 0;
		}
	}

	@Override
	public void render() {
		count++;
		mover();
		switch (color) {
		case 1:
			sketch.fill(145, 192, 30);
			break;
		case 2:
			sketch.fill(45, 139, 85);
		case 3:
			sketch.fill(45, 124, 78);
			break;
		case 4:
			sketch.fill(28, 99, 207);
			break;
		case 5:
			sketch.fill(75, 121, 191);
			break;

		}
		sketch.rect(getPosX(), getPosY(), 40, 20);
	}

	@Override
	public void run() {
		render();
		try {
			verPersonaje();
		} catch (JuegoPerdidoException e) {
			System.out.println(e.getMessage());
			getControlador().perder();
		}
	}

	public void verPersonaje() throws JuegoPerdidoException {

		double distancia = Math.hypot(getPosX() - getControlador().getPersonaje().getPosX(),
				getPosY() - getControlador().getPersonaje().getPosY());
		if (distancia < 20) {
			throw new JuegoPerdidoException();
		}

	}

}
