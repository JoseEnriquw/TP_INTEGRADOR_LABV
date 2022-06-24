package frgp.utn.edu.ar.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class EUsuario {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombreU;
	private String passU;
	
	public EUsuario()
	{
		
	}
	public EUsuario(Integer id)
	{
		this.id=id;
	}

	public String getNombreU() {
		return nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

	public String getPassU() {
		return passU;
	}

	public void setPassU(String passU) {
		this.passU = passU;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EUsuario(int id, String nombreU, String passU) {
		super();
		this.id = id;
		this.nombreU = nombreU;
		this.passU = passU;
	}
	
}
