package modelo;

import java.util.Date;

public class Partida implements Comparable<Partida>{
	
	private Date fechaHora;
	private int duracion;
	
	public Partida(Date fechaHora ) {
		this.fechaHora = fechaHora;
		this.duracion = 0;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public int compareTo(Partida o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
