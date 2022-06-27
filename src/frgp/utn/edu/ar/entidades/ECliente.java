package frgp.utn.edu.ar.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cliente")
public class ECliente {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@Column(unique=true)
	private String dni;
	
	private String nombre;
	
	private String apellido;
	
	@ManyToOne (cascade= {CascadeType. ALL})
	@JoinColumn
	private ENacionalidad nacionalidad;
	
	@Column(unique=true)
	private String email;
	
	private String direccion;
	
	private String localidad;

	private String telefono;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;
	
	public ECliente() {
		
	}
	
	public ECliente(String dni, String nombre, String apellido, ENacionalidad nacionalidad, String email,
			String direccion, String localidad, String telefono, Date fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.direccion = direccion;
		this.localidad = localidad;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public ECliente(Integer id) {
		this.id = id;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
		return "ECliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", nacionalidad=" + nacionalidad + ", email=" + email + ", direccion=" + direccion + ", localidad="
				+ localidad + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
