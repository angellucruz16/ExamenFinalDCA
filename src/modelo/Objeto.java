package modelo;

public class Objeto {
 
	private int id; 
	public Objeto(int id, int tipo, int posInicialX, int posInicialY, int posX, int posY) {
		this.id = id;
		this.tipo = tipo;
		this.posInicialX = posInicialX;
		this.posInicialY = posInicialY;
		this.posX = posX;
		this.posY = posY;
	}
	private int tipo;
	private int posInicialX;
	private int posInicialY;
	private int posX;
	private int posY;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getPosInicialX() {
		return posInicialX;
	}
	public void setPosInicialX(int posInicialX) {
		this.posInicialX = posInicialX;
	}
	public int getPosInicialY() {
		return posInicialY;
	}
	public void setPosInicialY(int posInicialY) {
		this.posInicialY = posInicialY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
		
}
