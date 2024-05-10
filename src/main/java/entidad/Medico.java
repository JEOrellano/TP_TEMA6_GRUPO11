package entidad;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.Sexo;

@Entity
@Table(name = "Medico")
public class Medico implements Serializable {
	// Implementar serializable
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "legajo", unique = true)
	private String legajo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "sexo")
	private Sexo sexo;

	@Column(name = "nacimiento", columnDefinition = "DATE")
	private Date nacimiento;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "localidad")
	private String localidad;

	@Column(name = "email")
	private String email;

	@Column(name = "telefono")
	private String telefono;

	// Constructor vacío requerido por Hibernate
	public Medico() {
	}

	public Medico(String legajo, String nombre, String apellido, Sexo sexo, Date nacimiento, String direccion,
			String localidad, String email, String telefono) {

		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacimiento = nacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.email = email;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Medico [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo="
				+ sexo + ", nacimiento=" + nacimiento + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", email=" + email + ", telefono=" + telefono + "]";
	}
}
