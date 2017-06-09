package testsCliente;

import java.io.IOException;

import javax.swing.JTextArea;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cliente.Cliente;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

public class TestCliente {
	
	
	
	@Test
	public void testPaquete() {
		
		Paquete paquete = new Paquete("lalala", "Cliente", "A", 1);
		Assert.assertEquals("lalala", paquete.getMensaje());
		Assert.assertEquals("A", paquete.getIp());
		Assert.assertEquals(1, paquete.getComando());
	}
	
	
	@Test
	public void testPaqueteAtacar() {
		PaqueteAtacar pAtacar = new PaqueteAtacar(1, 1, 1, 1, 1, 1);
		Assert.assertEquals(1, pAtacar.getId());
		Assert.assertEquals(1, pAtacar.getIdEnemigo());
	}
	
	
	
	@Test
	public void testPaqueteBatalla() {
		
		PaqueteBatalla pBatalla = new PaqueteBatalla();
		pBatalla.setId(1);
		pBatalla.setIdEnemigo(2);
		pBatalla.setMiTurno(true);
		Assert.assertEquals(1, pBatalla.getId());
		Assert.assertEquals(2, pBatalla.getIdEnemigo());
		Assert.assertTrue(pBatalla.isMiTurno());
	}
	
	
	@Test
	public void testPaqueteMovimiento() {
		
		PaqueteMovimiento pMovimiento = new PaqueteMovimiento(1,1,1);
		pMovimiento.setDireccion(1);
		pMovimiento.setFrame(1);
		Assert.assertEquals(1, pMovimiento.getIdPersonaje());
		Assert.assertEquals(1, pMovimiento.getPosX(),0.01);
		Assert.assertEquals(1, pMovimiento.getPosY(),0.01);
		Assert.assertEquals(1, pMovimiento.getDireccion());
		Assert.assertEquals(1, pMovimiento.getFrame());
	}
	
	

	@Test
	public void testPaquetePersonaje() {	
		PaquetePersonaje pPersonaje = new PaquetePersonaje();
		pPersonaje.setCasta("Hechicero");
		pPersonaje.setDestreza(1);
		pPersonaje.setEnergiaTope(1);
		pPersonaje.setEstado(1);
		pPersonaje.setExperiencia(1);
		pPersonaje.setFuerza(1);
		pPersonaje.setId(1);
		pPersonaje.setMapa(1);
		pPersonaje.setInteligencia(1);
		pPersonaje.setNivel(1);
		pPersonaje.setNombre("pepe");
		pPersonaje.setRaza("Orco");
		pPersonaje.setSaludTope(1);
		
		Assert.assertEquals("Hechicero", pPersonaje.getCasta());
		Assert.assertEquals(1, pPersonaje.getDestreza());
		Assert.assertEquals(1, pPersonaje.getEnergiaTope());
		Assert.assertEquals(1, pPersonaje.getEstado());
		Assert.assertEquals(1, pPersonaje.getExperiencia());
		Assert.assertEquals(1, pPersonaje.getFuerza());
		Assert.assertEquals(1, pPersonaje.getId());
		Assert.assertEquals(1, pPersonaje.getMapa());
		Assert.assertEquals(1, pPersonaje.getInteligencia());
		Assert.assertEquals(1, pPersonaje.getNivel());
		Assert.assertEquals("pepe", pPersonaje.getNombre());
		Assert.assertEquals("Orco", pPersonaje.getRaza());
		Assert.assertEquals(1, pPersonaje.getSaludTope());		
	}
	

	@Test
	public void testPaqueteFinalizarBatalla() {
		
		PaqueteFinalizarBatalla pFinBatalla = new PaqueteFinalizarBatalla();
		pFinBatalla.setId(1);
		pFinBatalla.setIdEnemigo(1);
		Assert.assertEquals(1, pFinBatalla.getId());
		Assert.assertEquals(1, pFinBatalla.getIdEnemigo());
	}
	
	@Test
	public void testPaqueteUsuario() {

		PaqueteUsuario pu = new PaqueteUsuario(1,"Fernando","ABC");
		Assert.assertEquals(1, pu.getIdPj());
		Assert.assertEquals("Fernando", pu.getUsername());
		Assert.assertEquals("ABC", pu.getPassword());
		Assert.assertFalse(pu.isInicioSesion());
	}

	

//	/// Para realizar los test es necesario iniciar el servidor
//
//	@Test
//	public void testConexionConElServidor() {
//		Gson gson = new Gson();
//
//		Cliente cliente = new Cliente();
//
//		// Pasado este punto la conexi�n entre el cliente y el servidor resulto exitosa
//		Assert.assertEquals(1, 1);
//
//		try {
//
//			// Cierro las conexiones
//			Paquete p = new Paquete();
//			p.setComando(Comando.DESCONECTAR);
//			p.setIp(cliente.getMiIp());
//			cliente.getSalida().writeObject(gson.toJson(p));
//			cliente.getSalida().close();
//			cliente.getEntrada().close();
//			cliente.getSocket().close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testRegistro() {
//		Gson gson = new Gson();
//
//		// Registro el usuario
//		PaqueteUsuario pu = new PaqueteUsuario();
//		pu.setComando(Comando.REGISTRO);
//		pu.setUsername("nuevoUser");
//		pu.setPassword("test");
//
//		Cliente cliente = new Cliente();
//
//		try {
//
//			// Envio el paquete para registrarme
//			cliente.getSalida().writeObject(gson.toJson(pu));
//
//			// Recibo la respuesta del servidor
//			Paquete resultado = (Paquete) gson.fromJson((String) cliente.getEntrada().readObject(), Paquete.class);
//
//			// Cierro las conexiones
//			Paquete p = new Paquete();
//			p.setComando(Comando.DESCONECTAR);
//			p.setIp(cliente.getMiIp());
//			cliente.getSalida().writeObject(gson.toJson(p));
//			cliente.getSalida().close();
//			cliente.getEntrada().close();
//			cliente.getSocket().close();
//
//			Assert.assertEquals(Paquete.msjExito, resultado.getMensaje());
//
//		} catch (JsonSyntaxException | ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testRegistroFallido() {
//		Gson gson = new Gson();
//
//		// Registro el usuario
//		PaqueteUsuario pu = new PaqueteUsuario();
//		pu.setComando(Comando.REGISTRO);
//		pu.setUsername("nuevoUser");
//		pu.setPassword("test");
//
//		Cliente cliente = new Cliente();
//
//		try {
//
//			// Envio el paquete para registrarme
//			cliente.getSalida().writeObject(gson.toJson(pu));
//
//			// Recibo la respuesta del servidor
//			Paquete resultado = (Paquete) gson.fromJson((String) cliente.getEntrada().readObject(), Paquete.class);
//
//			// Cierro las conexiones
//			Paquete p = new Paquete();
//			p.setComando(Comando.DESCONECTAR);
//			p.setIp(cliente.getMiIp());
//			cliente.getSalida().writeObject(gson.toJson(p));
//			cliente.getSalida().close();
//			cliente.getEntrada().close();
//			cliente.getSocket().close();
//
//			Assert.assertEquals(Paquete.msjFracaso, resultado.getMensaje());
//
//		} catch (JsonSyntaxException | ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testRegistrarPersonaje() {
//		Gson gson = new Gson();
//
//		Cliente cliente = new Cliente();
//
//		// Registro de usuario
//		PaqueteUsuario pu = new PaqueteUsuario();
//		pu.setComando(Comando.REGISTRO);
//		pu.setUsername("nuevoUser");
//		pu.setPassword("test");
//
//		// Registro de personaje
//		PaquetePersonaje pp = new PaquetePersonaje();
//		pp.setComando(Comando.CREACIONPJ);
//		pp.setCasta("Humano");
//		pp.setDestreza(1);
//		pp.setEnergiaTope(1);
//		pp.setExperiencia(1);
//		pp.setFuerza(1);
//		pp.setInteligencia(1);
//		pp.setNivel(1);
//		pp.setNombre("PjTest");
//		pp.setRaza("Asesino");
//		pp.setSaludTope(1);
//
//		try {
//
//			// Envio el paquete de registro de usuario
//			cliente.getSalida().writeObject(gson.toJson(pu));
//
//			// Recibo la respuesta del servidor
//			Paquete paquete = (Paquete) gson.fromJson((String) cliente.getEntrada().readObject(), Paquete.class);
//
//			// Envio el paquete de registro de personaje
//			cliente.getSalida().writeObject(gson.toJson(pp));
//
//			// Recibo el personaje de mi usuario
//			pp = (PaquetePersonaje) gson.fromJson((String) cliente.getEntrada().readObject(), PaquetePersonaje.class);
//
//			// Cierro las conexiones
//			Paquete p = new Paquete();
//			p.setComando(Comando.DESCONECTAR);
//			p.setIp(cliente.getMiIp());
//			cliente.getSalida().writeObject(gson.toJson(p));
//			cliente.getSalida().close();
//			cliente.getEntrada().close();
//			cliente.getSocket().close();
//
//			Assert.assertEquals("PjTest", pp.getNombre());
//		} catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testIniciarSesion() {
//		Gson gson = new Gson();
//		Cliente cliente = new Cliente();
//
//		PaqueteUsuario pu = new PaqueteUsuario();
//		pu.setComando(Comando.INICIOSESION);
//		pu.setUsername("nuevoUser");
//		pu.setPassword("test");
//
//		try {
//
//			// Envio el paquete de incio de sesion
//			cliente.getSalida().writeObject(gson.toJson(pu));
//
//			// Recibo el paquete con el personaje
//			PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
//					.fromJson((String) cliente.getEntrada().readObject(), PaquetePersonaje.class);
//
//			// Cierro las conexiones
//			Paquete p = new Paquete();
//			p.setComando(Comando.DESCONECTAR);
//			p.setIp(cliente.getMiIp());
//			cliente.getSalida().writeObject(gson.toJson(p));
//			cliente.getSalida().close();
//			cliente.getEntrada().close();
//			cliente.getSocket().close();
//
//			Assert.assertEquals("PjTest", paquetePersonaje.getNombre());
//		} catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testActualizarPersonaje() {
//		Gson gson = new Gson();
//		Cliente cliente = new Cliente();
//
//		PaquetePersonaje pp = new PaquetePersonaje();
//		pp.setComando(Comando.ACTUALIZARPERSONAJE);
//		pp.setCasta("Humano");
//		pp.setDestreza(1);
//		pp.setEnergiaTope(1);
//		pp.setExperiencia(1);
//		pp.setFuerza(1);
//		pp.setInteligencia(1);
//		pp.setNivel(1);
//		pp.setNombre("PjTest");
//		pp.setRaza("Asesino");
//		pp.setSaludTope(10000);
//
//		try {
//
//			// Envio el paquete de actualizacion de personaje
//			cliente.getSalida().writeObject(gson.toJson(pp));
//
//			// Recibo el paquete con el personaje actualizado
//			PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
//					.fromJson((String) cliente.getEntrada().readObject(), PaquetePersonaje.class);
//
//			// Cierro las conexiones
//			Paquete p = new Paquete();
//			p.setComando(Comando.DESCONECTAR);
//			p.setIp(cliente.getMiIp());
//			cliente.getSalida().writeObject(gson.toJson(p));
//			cliente.getSalida().close();
//			cliente.getEntrada().close();
//			cliente.getSocket().close();
//
//			Assert.assertEquals(10000, paquetePersonaje.getSaludTope());
//		} catch (IOException | JsonSyntaxException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
}
