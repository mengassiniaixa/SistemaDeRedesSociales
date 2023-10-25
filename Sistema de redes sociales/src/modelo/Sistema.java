package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> lstUsuarios;
	private List<Publicacion> lstPublicaciones;
	private List<Comentario> lstComentarios;

	public Sistema() {
		super();
		this.lstUsuarios = new ArrayList<Usuario>();
		this.lstPublicaciones = new ArrayList<Publicacion>();
		this.lstComentarios = new ArrayList<Comentario>();
	}

	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}

	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}

	public List<Publicacion> getLstPublicaciones() {
		return lstPublicaciones;
	}

	public void setLstPublicaciones(List<Publicacion> lstPublicaciones) {
		this.lstPublicaciones = lstPublicaciones;
	}

	public List<Comentario> getLstComentarios() {
		return lstComentarios;
	}

	public void setLstComentarios(List<Comentario> lstComentarios) {
		this.lstComentarios = lstComentarios;
	}

	@Override
	public String toString() {
		return "Sistema [lstUsuarios=" + lstUsuarios + ", lstPublicaciones=" + lstPublicaciones + ", lstComentarios="
				+ lstComentarios + "]";
	}

	public Usuario traerUsuario(String nombreUsuario) {
		Usuario usuario = null;

		int i = 0;
		while (i < lstUsuarios.size() && usuario == null) {
			if (lstUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)) {
				usuario = lstUsuarios.get(i);
			}
			i++;
		}
		return usuario;
	}

	public boolean agregarUsuario(String nombreUsuario, LocalDate fechaAlta) throws Exception {
		if (traerUsuario(nombreUsuario) != null) {
			throw new Exception("Error: ya existe un usuario con ese nombre");
		}

		int id = 1;
		if (lstUsuarios.size() > 0) {
			id = lstUsuarios.get(lstUsuarios.size() - 1).getIdUsuario() + 1;
		}
		return lstUsuarios.add(new Usuario(id, nombreUsuario, fechaAlta));

	}

	public Publicacion traerPublicacion(String nombreUsuario, LocalDate fecha, LocalTime hora) {
		Publicacion publicacion = null;

		int i = 0;
		while (i < lstPublicaciones.size() && publicacion == null) {
			if ((lstPublicaciones.get(i).getCreador().getNombreUsuario().equals(nombreUsuario))
					&& (lstPublicaciones.get(i).getFecha().equals(fecha))
					&& (lstPublicaciones.get(i).getHora().equals(hora))) {
				publicacion = lstPublicaciones.get(i);
			}
			i++;
		}
		return publicacion;
	}

	public boolean agregarPosteo(LocalDate fecha, LocalTime hora, Usuario creador, String text, boolean publico)
			throws Exception {
		if (traerPublicacion(creador.getNombreUsuario(), fecha, hora) != null) {
			throw new Exception("Error: ya existe un posteo con ese creador, fecha y hora.");
		}

		int id = 1;
		if (lstPublicaciones.size() > 0) {
			id = lstPublicaciones.get(lstPublicaciones.size() - 1).getIdPublicacion() + 1;
		}
		return lstPublicaciones.add(new Posteo(id, fecha, hora, creador, text, publico));

	}

	public boolean agregarAvisoGeneral(LocalDate fecha, LocalTime hora, Usuario creador, String texto, String cuerpo) throws Exception {
		if(traerPublicacion(creador.getNombreUsuario(), fecha, hora)!=null) {
			throw new Exception ("Error: ya existe un aviso general con ese creador, fecha y hora");
		}
		int id = 1;
		
		
		if(lstPublicaciones.size()>0) {
			id = lstPublicaciones.get(lstPublicaciones.size()-1).getIdPublicacion()+1;
		}
		return lstPublicaciones.add(new AvisoGeneral(id, fecha, hora, creador, texto, cuerpo));
	}

	public boolean agregarComentario(int identificacion, Publicacion publicacion, Usuario usuario, String texto) {
		int id = 1;
		if(this.lstComentarios.size()>0) {
			id = this.lstComentarios.get(this.lstComentarios.size()-1).getIdComentario()+1;
		}
		return this.lstComentarios.add(new Comentario(id, identificacion, publicacion, usuario, texto));
	}
	
	//8) + traerPublicacionesPublicas: List<Publicacion>
	
	public List<Publicacion> traerPublicacionesPublicas(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Publicacion> publicaciones = new ArrayList<Publicacion>(); 
		
		for(int i = 0; i< lstPublicaciones.size(); i++){
			
			Publicacion publicacionAux = lstPublicaciones.get(i);
			
			if(! (publicacionAux.getFecha().isBefore(fechaDesde) || publicacionAux.getFecha().isAfter(fechaHasta))) {
			
				if(publicacionAux instanceof AvisoGeneral) {
					publicaciones.add(publicacionAux);
				
				}else {
				
					Posteo posteoAux= (Posteo) publicacionAux;
					
					if(posteoAux.isPublico()) {
						publicaciones.add(publicacionAux);
					}
				}
			}
		}
		
		return publicaciones;
	}
	
	public List<Comentario> traerComentariosEnPosteosPorUsuario(Usuario usuario){
		List<Comentario> comentarios = new ArrayList<Comentario>();
		
		for(int i = 0; i< lstComentarios.size(); i++) {
			
			if(lstComentarios.get(i).getUsuario().equals(usuario)) {
				if(lstComentarios.get(i).getPublicacion() instanceof Posteo) {
					comentarios.add(lstComentarios.get(i));
				}
			}
			
		}
		
		return comentarios;
	}
	
	public List<Publicacion> traerPublicacionesQueContenganTexto(String texto){
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		
		for(int i = 0; i < lstPublicaciones.size(); i++) {
			if(lstPublicaciones.get(i).contieneTexto(texto)) {
				publicaciones.add(lstPublicaciones.get(i));
			}
		}
		return publicaciones;
	}
	
	
	
	
	/*public List<Publicacion> traerPublicacionesPublicas(LocalDate fechaDesde, LocalDate fechaHasta){
	
		  List<Publicacion> listAux = new ArrayList<Publicacion>();
		  
		  for(Publicacion publicacion : lstPublicaciones) {
			  if((publicacion.getFecha().isAfter(fechaDesde) || publicacion.getFecha().equals(fechaDesde))
				&& publicacion.getFecha().isBefore(fechaHasta) || publicacion.getFecha().equals(fechaHasta)) {
				  
			  }
		  }
		
	}*/
	
	/*
	public List<Publicacion> traerPublicacionesPublicas(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Publicacion> nueva= new ArrayList<>();
		
		for (int i=0;i<this.lstPublicaciones.size();i++) {
			
			//if the publication in position "i" is an instance of "general notice" and the date is between the given parameters
			
			if (this.lstPublicaciones.get(i) instanceof AvisoGeneral && fechaValidaEntreDosFechas(fechaDesde, fechaHasta, this.lstPublicaciones.get(i).getFecha() ) ) {
				nueva.add(this.lstPublicaciones.get(i));
			}
			
			//o si la publicacion en la posicion i es instancia de aviso general y la fecha se encuentra en los rangos dados:
			
			else if (this.lstPublicaciones.get(i) instanceof Posteo && fechaValidaEntreDosFechas(fechaDesde, fechaHasta, this.lstPublicaciones.get(i).getFecha())
					 && ((Posteo)this.lstPublicaciones.get(i)).isPublico()) {
				
				
				nueva.add(this.lstPublicaciones.get(i));
			}
			
		}
		
		return nueva;
	}
	*/
	
	public static boolean fechaValidaEntreDosFechas (LocalDate fechaAntes, LocalDate fechaDespues, LocalDate fechaProbar) {
        boolean aux= false;
        if((fechaProbar.isBefore(fechaDespues) || fechaProbar.isEqual(fechaDespues)) &&
        		(fechaProbar.isAfter(fechaAntes) || fechaProbar.isEqual(fechaAntes) )) {
            		aux=true;
        }
        return aux;
    }

	
	
}
