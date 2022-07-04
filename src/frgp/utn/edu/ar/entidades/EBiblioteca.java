package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Check;


@Entity
@Table(name="biblioteca")
public class EBiblioteca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date fechaAlta;
	
    //1- En biblioteca, 2- Prestado	
	@Check(constraints = "estado =1 OR estado=2")
	private Integer estado;
	
	@ManyToOne(cascade= {CascadeType. ALL})
	@JoinColumn(name="id_libro")
	private ELibro libro ;
	
	

	public EBiblioteca(int id, Date fechaAlta, Integer estado, ELibro libro) {
		
		this.id = id;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		libro = libro;
	}

	public EBiblioteca(Date fechaAlta, Integer estado, ELibro libro) {
		
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		libro = libro;
	}

	public ELibro getLibro() {
		return libro;
	}

	public void setLibro(ELibro libro) {
		libro = libro;
	}

	public EBiblioteca() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EBiblioteca [id=" + id + ", fechaAlta=" + fechaAlta + ", estado=" + estado + "]";
	}


}
