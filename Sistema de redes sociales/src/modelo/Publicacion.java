package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public abstract class Publicacion {
	protected int idPublicacion;
	protected LocalDate fecha;
	protected LocalTime hora;
	protected Usuario creador;

	public Publicacion(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador) {
		super();
		this.idPublicacion = idPublicacion;
		this.fecha = fecha;
		this.hora = hora;
		this.creador = creador;
	}

	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Publicacion [idPublicacion=" + idPublicacion + ", creador=" + creador + "]\n";
	}

	//equals
	public boolean equals (Publicacion publicacion) {
		return this.fecha.equals(publicacion.getFecha()) && this.hora.equals(publicacion.getHora()) && this.creador.equals(publicacion.creador);
	}
	
	public abstract boolean contieneTexto(String buscar);

}
