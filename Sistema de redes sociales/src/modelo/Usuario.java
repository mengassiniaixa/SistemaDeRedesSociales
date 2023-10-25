package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario {

	private int idUsuario;
	private String nombreUsuario;
	private LocalDate fechaAlta;

	public Usuario(int idUsuario, String nombreUsuario, LocalDate fechaAlta) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.fechaAlta = fechaAlta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", fechaAlta=" + fechaAlta
				+ "]\n";
	}

	//equals
	public boolean equals(Usuario u) {
		return u.getNombreUsuario().equals(this.nombreUsuario);
	}

	
}
