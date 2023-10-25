package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AvisoGeneral extends Publicacion {

	private String titulo;
	private String cuerpo;

	public AvisoGeneral(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String titulo,
			String cuerpo) {
		super(idPublicacion, fecha, hora, creador);
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return "AvisoGeneral [titulo=" + titulo + ", cuerpo=" + cuerpo + "]\n";
	}
	
	public boolean contieneTexto(String buscar) {
		return (titulo.indexOf(buscar)>=0 || cuerpo.indexOf(buscar) >=0);
	}
	
/*	
	//otra forma puede ser
	public boolean contieneTexto(String buscar) {

		int indice = -1;
		
		if(this.titulo.indexOf(buscar) != -1) {
			indice = this.titulo.indexOf(buscar);
		}else if(this.cuerpo.indexOf(buscar) != -1) {
			indice = this.cuerpo.indexOf(buscar);
		}
		return indice != -1;
	}*/

	
	//otr forma puede ser:
	/*public boolean contieneTexto(String buscar) {
		boolean existe = false;
		if(this.getTitulo().indexOf(buscar)>=0 || this.getCuerpo().indexOf(buscar)>=0) {
			existe=true;
		}
		return true;
	}*/
	
}
