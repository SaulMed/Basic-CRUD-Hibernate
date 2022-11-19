package mx.test.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Clientes")
public class Cliente {
	
//CONSTRUCTORES
	public Cliente(){}
	
	public Cliente(String nombre, String apellidos, Long telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

//PROPIEDADES

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//Identity va perfecto con campo AutoIncrementable
	@Column(name="Id")
	private int id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellidos")
	private String apellidos;
	
	@Column(name="Telefono")
	private Long telefono;

//METODOS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
	}
	
}
