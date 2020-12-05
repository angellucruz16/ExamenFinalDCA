package modelo;

import java.util.Date;

public class Partida implements Comparable<Partida> {

	private Date fechaHora;
	private int duracion;

	public Partida(Date fechaHora) {
		this.fechaHora = fechaHora;
		this.duracion = 0;
	}

	@Override
	public int compareTo(Partida o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public Date getFechaHora() {
		return fechaHora;
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
