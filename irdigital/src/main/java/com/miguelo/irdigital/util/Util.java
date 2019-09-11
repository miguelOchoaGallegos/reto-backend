package com.miguelo.irdigital.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.miguelo.irdigital.domain.Person;
import com.miguelo.irdigital.dto.PersonRequest;
import com.miguelo.irdigital.dto.PersonResponse;

public class Util {

    public static boolean esNuloVacio(String param) {
        if(param == null) return false;
        if(param.trim().length()==0) return false;
        return true;
    }
    public static boolean verifyDate(String dateParam){
        boolean response = true;
        try {
            DateTimeFormatter formatterFrom = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dateParam,formatterFrom);
            LocalDate currentDate = LocalDate.now();
            if(currentDate.isBefore(date)) response = false;
        }catch (Exception ex) {
            response = false;
        }
        return response;
    }
    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }
    public static String calculateDateDead(String fecNacimiento) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate datefecNacimiento = LocalDate.parse(fecNacimiento,formatter);
    	Long randomYears = (long) getRandomDoubleBetweenRange(70,120);
    	double weeksInYears=52.1429;
    	Long randomweeks = (long) (randomYears*weeksInYears);
    	LocalDate dateDead = datefecNacimiento.plusWeeks(randomweeks);
    	return dateDead.format(formatter);
    }
    public static int calculateAge(String fecNacimiento){
    	long diffInYears=0;
        try {        	
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	LocalDate datefecNacimiento = LocalDate.parse(fecNacimiento,formatter);
    		LocalDate currentDate = LocalDate.now();        	
    		diffInYears = ChronoUnit.YEARS.between(datefecNacimiento, currentDate);
        }catch (Exception ex) {            
        }
        return (int) diffInYears;
    }

    public static Person transformRequestToModel(PersonRequest request) {
        return new Person(request.getNombre(), request.getApellido(), calculateAge(request.getFechaNacimiento()) , request.getFechaNacimiento());
    }

    public static PersonResponse transformModelToResponse(Person persona) {
        return new PersonResponse(
        		String.valueOf(persona.getId()),
        		persona.getNombre(),
        		persona.getApellido(),
        		persona.getEdad(),
        		persona.getFecNacimiento(),
        		calculateDateDead(persona.getFecNacimiento())
        		);
        		
    }
}
