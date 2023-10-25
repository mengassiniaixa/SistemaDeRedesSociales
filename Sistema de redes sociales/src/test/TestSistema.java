package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Sistema;

public class TestSistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sistema sistema = new Sistema();
		
		System.out.println("Test 1: ");
		try {
			
			sistema.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1));
			sistema.agregarUsuario("usuarioCreador2", LocalDate.of(2023, 9, 2));
			sistema.agregarUsuario("usuarioCreador3", LocalDate.of(2023, 9, 3));
			sistema.agregarUsuario("usuarioCreador4", LocalDate.of(2023, 9, 4));
			sistema.agregarUsuario("usuarioCreador5", LocalDate.of(2023, 9, 5));
			
			sistema.agregarUsuario("usuarioLector1", LocalDate.of(2023, 9, 6));
			sistema.agregarUsuario("usuarioLector2", LocalDate.of(2023, 9, 7));
			sistema.agregarUsuario("usuarioLector3", LocalDate.of(2023, 9, 8));
			
	
		System.out.println(sistema.getLstUsuarios());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Test 2:");
		try {
			sistema.agregarPosteo(LocalDate.of(2023, 10, 1), LocalTime.of(10, 00), sistema.traerUsuario("usuarioCreador1"), "Que dia es el segundo parcial de oo1?", true);
			sistema.agregarPosteo(LocalDate.of(2023, 10, 5), LocalTime.of(11, 00), sistema.traerUsuario("usuarioCreador2"), "Comenten de que pais me estan leyendo", true);
			sistema.agregarPosteo(LocalDate.of(2023, 10, 10), LocalTime.of(12, 00), sistema.traerUsuario("usuarioCreador3"), "Hoy nos reunimos en mi casa", false);
			sistema.agregarAvisoGeneral(LocalDate.of(2023, 10, 15), LocalTime.of(13, 00), sistema.traerUsuario("usuarioCreador4"), "Alerta para vecinos de Lanus", "anuncian fuertes lluvias para las 18HS");
			sistema.agregarAvisoGeneral(LocalDate.of(2023, 10, 15), LocalTime.of(14, 00), sistema.traerUsuario("usuarioCreador5"), "Informacion importante", "la facultad permanecera abierta hasta las 20HS");
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(sistema.getLstPublicaciones());
	
		System.out.println("Test 3:");
		
		sistema.agregarComentario(111, sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 0)), sistema.traerUsuario("usuarioLector2"), "Uruguay");
		sistema.agregarComentario(222, sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 0)), sistema.traerUsuario("usuarioLector2"), "Chile");
		sistema.agregarComentario(333, sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 01), LocalTime.of(10, 0)), sistema.traerUsuario("usuarioCreador1"), "No recuerdo");
		sistema.agregarComentario(444, sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 01), LocalTime.of(10, 0)), sistema.traerUsuario("usuarioLector1"), "Es el martes 17/10/2023");
		
		System.out.println(sistema.getLstComentarios());
		
		System.out.println("\nTest 4:");
		System.out.println(sistema.traerPublicacionesPublicas(LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 15)));
		
		System.out.println("\nTest 5: ");
		System.out.println(sistema.traerComentariosEnPosteosPorUsuario(sistema.traerUsuario("usuarioLector2"))); 
		
		System.out.println("\nTest 6: ");
		System.out.println(sistema.traerPublicacionesQueContenganTexto("de"));
		
	}

}
