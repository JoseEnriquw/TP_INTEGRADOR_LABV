package frgp.utn.edu.ar.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nacionalidad")
public class ENacionalidad {

	private static final long serialVersionUID=1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@Column
	private String descripcion;
	
	public ENacionalidad() {
		
	}

	public ENacionalidad(String descripcion) {
		this.descripcion = descripcion;
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

	public void setDescripcion(String Descripcion) {
		descripcion = Descripcion;
	}

	@Override
	public String toString() {
		return "ENacionalidad [ID=" + id + ", Descripcion=" + descripcion + "]";
	}
	
}
