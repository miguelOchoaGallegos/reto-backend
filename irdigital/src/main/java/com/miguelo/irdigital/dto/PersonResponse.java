package com.miguelo.irdigital.dto;

public class PersonResponse {
	private String id;
	private String nombre;
    private String apellido;
    private int edad;
    private String fechaNacimiento;
    private String fechaProbableMuerte;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFechaProbableMuerte() {
		return fechaProbableMuerte;
	}
	public void setFechaProbableMuerte(String fechaProbableMuerte) {
		this.fechaProbableMuerte = fechaProbableMuerte;
	}
	public PersonResponse(String id, String nombre, String apellido, int edad, String fechaNacimiento,
			String fechaProbableMuerte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaProbableMuerte = fechaProbableMuerte;
	}
	
    
}
