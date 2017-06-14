package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idEnemigo;
	
	

	private HashMap<String, Integer> atributosPersonaje = new HashMap<String, Integer>();
	private HashMap<String, Integer> atributosEnemigo = new HashMap<String, Integer>();
	
	public PaqueteAtacar(int id, int idEnemigo, int nuevaSalud, int nuevaEnergia, int nuevaSaludEnemigo, int nuevaEnergiaEnemigo) {
		setComando(Comando.ATACAR);
		this.id = id;
		this.idEnemigo = idEnemigo;
		
		
		atributosPersonaje.put("salud", nuevaSalud);
		atributosPersonaje.put("energia", nuevaEnergia);
		atributosEnemigo.put("salud", nuevaSaludEnemigo);
		atributosEnemigo.put("energia", nuevaEnergiaEnemigo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEnemigo() {
		return idEnemigo;
	}

	public void setIdEnemigo(int idEnemigo) {
		this.idEnemigo = idEnemigo;
	}
	

	public HashMap<String, Integer> getAtributosPersonaje() {
		return this.atributosPersonaje;
	}

	public HashMap<String, Integer> getAtributosEnemigo() {
		return this.atributosEnemigo;
	}


}
