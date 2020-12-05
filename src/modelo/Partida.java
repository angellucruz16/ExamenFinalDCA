package modelo;

import java.util.Date;

public class Partida implements Comparable<Partida> {

	private Date fechaHora;
	private int duracion;
	private int id;

	public Partida(int id, Date fechaHora) {
		System.out.println("Nueva partida iniciada");
		this.fechaHora = fechaHora;
		this.duracion = 0;
		this.id = id;
	}

	@Override
	public int compareTo(Partida o) {
		int last = this.fechaHora.compareTo(o.fechaHora);
		// Sorting by first name if last name is same d
		return last == 0 ? this.fechaHora.compareTo(o.fechaHora) : last;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public int getId() {
		return id;
	}

	public int setDuracion() {
		Date momento = new Date();
		int duracion = (int) ((momento.getTime() - fechaHora.getTime()) / 1000);
		this.duracion = duracion;
		return duracion;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

}
