package frgp.utn.edu.ar.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;



@Entity
@Table(name="libro")
public class ELibro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int isbn;
	
	private String titulo;
	
	private Date fechaLanzamiento;
	
	private String idioma;
	
	private Integer cantPaginas;
	
	@ManyToOne (cascade= {CascadeType. ALL})
	@JoinColumn
	private EAutor autor;

	private String descripcion;
	
	@ManyToMany (cascade= {CascadeType. ALL},fetch=FetchType.EAGER)
	@JoinTable(name="generos_x_libro", joinColumns = {@JoinColumn(name = "isbn")}, inverseJoinColumns = {@JoinColumn(name="id_genero")})
	private List<EGenero> generos;

	public ELibro() {
		
	}

	public ELibro(String titulo, Date fechaLanzamiento, String idioma, Integer cantPaginas, EAutor autor,
			String descripcion, List<EGenero> generos) {
		super();
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.idioma = idioma;
		this.cantPaginas = cantPaginas;
		this.autor = autor;
		this.descripcion = descripcion;
		this.generos = generos;
	}

	public int getId() {
		return isbn;
	}

	public void setId(int id) {
		this.isbn = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Integer getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(Integer cantPaginas) {
		this.cantPaginas = cantPaginas;
	}

	public EAutor getAutor() {
		return autor;
	}

	public void setAutor(EAutor autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<EGenero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<EGenero> generos) {
		this.generos = generos;
	}
	
	

	@Override
	public String toString() {
		
		String sGeneros = "";
		for(EGenero genero: generos) { 
		sGeneros+="\n -"+genero.toString();
		
		}
		return "ELibro [isbn=" + isbn + ", titulo=" + titulo + ", fechaLanzamiento=" + fechaLanzamiento + ", idioma="
				+ idioma + ", cantPaginas=" + cantPaginas + ", autor=" + autor 
				+ ", descripcion=" + descripcion + ", generos=" +sGeneros+ "]";
	}
	
	public String getGenerosString() {
		String generos = "";
		for (EGenero genero : this.getGeneros()) {
			generos += genero.getDescripcion()+", " ;
		}
		return generos.substring(0,generos.length()-2);
	}
	
	public String ConvertToJson() {
		return new Gson().toJson(this);
	}


	

}
