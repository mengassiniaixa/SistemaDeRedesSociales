package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Posteo extends Publicacion {

	private String texto;
	private boolean publico;

	public Posteo(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico) {
		super(idPublicacion, fecha, hora, creador);
		this.texto = texto;
		this.publico = publico;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	@Override
	public String toString() {
		return "Posteo [" +super.toString() +", texto=" + texto + ", publico=" + publico + "]\n";
	}
	
	public boolean contieneTexto(String buscar) {
		return (texto.indexOf(buscar)>=0);
	}
	
	
	
}
