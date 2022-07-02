package frgp.utn.edu.ar.entidades;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="autor")
public class EAutor {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@ManyToOne (cascade= {CascadeType. ALL})
	@JoinColumn
	private ENacionalidad nacionalidad;
	
	@Column(unique=true)
	private String email;
	
	public EAutor() {
		
	}
	
	public EAutor(String nombre, String apellido, ENacionalidad nacionalidad, String email) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
	}
	
	public EAutor(Integer id,String nombre, String apellido, ENacionalidad nacionalidad, String email) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
	}



	public EAutor(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ENacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(ENacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EAutor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad
				+ ", email=" + email + "]";
	}
	
	public String ConvertToJson() {
		return new Gson().toJson(this);
	}

	
}
