package com.miguelo.irdigital.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miguelo.irdigital.domain.Person;
import com.miguelo.irdigital.dto.PersonRequest;
import com.miguelo.irdigital.dto.PersonResponse;
import com.miguelo.irdigital.dto.PromedioResponse;
import com.miguelo.irdigital.repository.PersonRepository;
import com.miguelo.irdigital.util.Util;

import service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
    PersonRepository personRepository;

	@Override
	public Map<String, Object> save(PersonRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> response = new HashMap<String, Object>();
		// validate request
		response.put("rpta", false);		
		if(!Util.esNuloVacio(request.getNombre())) {response.put("msg", "El valor nombre es requerido");return response;}
		if(!Util.esNuloVacio(request.getApellido())) {response.put("msg", "El valor apellido es requerido");return response;}		
		if(!Util.verifyDate(request.getFechaNacimiento())) { response.put("msg", "El valor fecha de nacimiento es incorrecta");return response;}
		
		try {
			
			// transform
			Person person= Util.transformRequestToModel(request); 
			personRepository.save(person);			
			
			response.put("rpta", true);
			response.put("msg", "Item generado con el codigo : ".concat(String.valueOf(person.getId())));
			
		} catch (Exception e) {
			// TODO: handle exception
			response.put("rpta", false);
			response.put("msg", e.getMessage());
		}		
		
		return response;
	}

	@Override
	public List<PersonResponse> getAll() {
		// TODO Auto-generated method stub
		List<PersonResponse> persons = new ArrayList<PersonResponse>();
        personRepository.findAll().forEach(person -> persons.add(Util.transformModelToResponse(person)));
        
        
		return persons;
	}

	@Override
	public PromedioResponse getPromedio() {
		// TODO Auto-generated method stub
		PromedioResponse response = new PromedioResponse();
		List<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> persons.add(person));
		// obteniendo promedio aritmetico de edades 
		double average = persons.stream()				
		.mapToDouble(Person::getEdad)
		.average()
		.orElse(Double.NaN);
		// obteniendo desviacion estandar
		//1 hallar la medio
		double mediaValue = average;
		// 2 distancia de cada media : (x-u) 2
		double sumaMedia = 0.0;
		for (Person item : persons) {
			sumaMedia = sumaMedia + Math.pow(item.getEdad()-mediaValue, 2);
		}
		// 3 dividir entre n 
		double resultlDividValue = sumaMedia/persons.size();
		// 4 raiz cuadrada del resultado anterior
		double resultValue = Math.sqrt(resultlDividValue);
		
		response.setPromedioAritmetico(String.valueOf(average));
		response.setDesviacionEstandar(String.valueOf(resultValue));
		return response;
	}

}
