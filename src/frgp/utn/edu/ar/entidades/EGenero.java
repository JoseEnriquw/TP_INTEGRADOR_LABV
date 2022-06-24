package frgp.utn.edu.ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genero")
public class EGenero implements Serializable{

	private static final long serialVersionUID=1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@Column
	private String descripcion;
	
	public EGenero() {
		
	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer iD) {
		id = iD;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EGenero [ID=" + id + ", Descripcion=" + descripcion + "]";
	}
	
	
	
}
