package com.karla.modelos;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor proporciona el nombre de usuario de usuario.")
    @Size(min = 3, max = 15, message = "Por favor proporciona el nombre del usuario.")
	@Column(name="nombre_usuario", unique = true)
	private String nombreUsuario;
	
	@NotBlank(message = "Por favor proporciona la contraseña.")
	@Size(min=8, message="La contraseña necesita tener al menos 8 caracteres.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña necesita incluir al menos una letra mayúscula, una letra minúscula y un número")
	private String contrasenia;
	
	@Transient
	@NotBlank(message = "Por favor proporciona la conformación de su contraseña.")
	private String confirmacionContrasenia;
	
	@NotBlank(message = "Por favor proporciona el correo.")
    @Email(message="Por favor proporciona un correo válido.")
	private String correo;
	
	@NotBlank(message = "Por favor proporciona el nombre de usuario.")
    @Size(min = 3, message = "Ingrese un nombre con al menos 3 caracteres.")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String nombre;
	
	@NotBlank(message = "Por favor proporciona el apellido de usuario.")
    @Size(min = 3, message = "Ingrese un apellido con al menos 3 caracteres.")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String apellido;
	
	@Past(message = "Debe ser una fecha del pasado.")
	@Column(name="fecha_nacimiento")
    private LocalDate fechaDeNacimiento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;
	
	public Usuario() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getConfirmacionContrasenia() {
		return confirmacionContrasenia;
	}

	public void setConfirmacionContrasenia(String confirmacionContrasenia) {
		this.confirmacionContrasenia = confirmacionContrasenia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@PrePersist
	protected void onCreate() {
		this.fechaCreacion = new Date();
		this.fechaActualizacion = this.fechaCreacion;
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.fechaActualizacion = new Date();
	}
}