package com.miguelo.irdigital.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Person {

	@Id
    @GeneratedValue
    @Column    
    private int id;
	
	@Column
    private String nombre;
	
	@Column
    private String apellido;
	
	@Column
    private int edad;
	
	@Column
    private String fecNacimiento;

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

	public String getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(String fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public Person() {}
	
	public Person(String nombre, String apellido, int edad, String fecNacimiento) {
		super();		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fecNacimiento = fecNacimiento;
	}		
    
}
