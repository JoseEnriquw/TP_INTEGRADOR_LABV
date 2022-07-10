package frgp.utn.edu.ar.entidades;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.Gson;

@Entity
@Table(name="prestamo")
public class EPrestamo {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	@ManyToOne (cascade= {CascadeType. ALL})
	@JoinColumn
	private EBiblioteca biblioteca;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaPrestamo;
	
	private Integer cantDias;
	
	@ManyToOne (cascade= {CascadeType. ALL})
	@JoinColumn(name="cliente_id")
	private ECliente cliente;

	public EPrestamo() {
		
	}
	
	

	public EPrestamo(EBiblioteca biblioteca, Date fechaPrestamo, Integer txtDias, ECliente cliente) {
		
		this.biblioteca = biblioteca;
		this.fechaPrestamo = fechaPrestamo;
		this.cantDias = txtDias;
		this.cliente = cliente;
	}
	
	/*PARA LAS PRUEBAS*/	
	



	public EPrestamo(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EBiblioteca getBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(EBiblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Integer getCantDias() {
		return cantDias;
	}

	public void setCantDias(Integer cantDias) {
		this.cantDias = cantDias;
	}

	public ECliente getCliente() {
		return cliente;
	}

	public void setCliente(ECliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "EPrestamo [id=" + id + ", biblioteca=" + biblioteca + ", fechaPrestamo=" + fechaPrestamo + ", cantDias="
				+ cantDias + ", cliente=" + cliente + "]";
	}
	
	public String ConvertToJson() {
		return new Gson().toJson(this);
	}
	
}
