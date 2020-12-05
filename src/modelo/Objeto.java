package modelo;

import processing.core.PApplet;

public class Objeto {

	private int id;
	private int direccion;
	private int posInicialX;
	private int posInicialY;
	private int posX;
	private int posY;
	PApplet sketch;

	public Objeto(int id, int direccion, int posInicialX, int posInicialY, int posX, int posY, PApplet sketch) {
		this.id = id;
		this.direccion = direccion;
		this.posInicialX = posInicialX;
		this.posInicialY = posInicialY;
		this.posX = posX;
		this.posY = posY;
		this.sketch = sketch;
	}

	public int getDireccion() {
		return direccion;
	}

	public int getId() {
		return id;
	}

	public int getPosInicialX() {
		return posInicialX;
	}

	public int getPosInicialY() {
		return posInicialY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void mover() {

		System.out.println("mover ");
	}

	public void render() {

	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPosInicialX(int posInicialX) {
		this.posInicialX = posInicialX;
	}

	public void setPosInicialY(int posInicialY) {
		this.posInicialY = posInicialY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
