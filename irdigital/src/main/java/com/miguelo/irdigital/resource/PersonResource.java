package com.miguelo.irdigital.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguelo.irdigital.dto.PersonRequest;
import com.miguelo.irdigital.dto.PersonResponse;
import com.miguelo.irdigital.dto.PromedioResponse;

import exception.GenericException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import service.PersonService;

@RestController
@RequestMapping("/persona")
@Api(tags = "Personal", description = "Realiza las tareas relacionadas para la entidad persona")
public class PersonResource {

	@Autowired
    PersonService personService;

    @ApiOperation(value = "creacliente", notes = "crea los clientes usando atributos: nombre, apellido, edad, fecha de nacimiento")
    @PostMapping(path = "/creacliente")
    public ResponseEntity<String> creacliente(@RequestBody PersonRequest request) {
        try {
            Map<String, Object> response  = personService.save(request);
            boolean rpta = (boolean) response.get("rpta");
            return new ResponseEntity<String>(response.get("msg").toString(), rpta?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);            
        } catch (Exception e) {
            // TODO: handle exception
        	throw new GenericException(e.getMessage(), e);
        }
    }
    
    @ApiOperation(value = "listclientes", notes = "Lista las personas con los datos registrados + fecha probable de muerte")
    @GetMapping(path = "/listclientes")
    public ResponseEntity<List<PersonResponse>> listclientes() {
        try {
            return new ResponseEntity<List<PersonResponse>>(personService.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception            
            throw new GenericException(e.getMessage(), e);
        }
    }

    @ApiOperation(value = "kpideclientes", notes = "Obtiene promedio de edad de los clientes + desviacion estandar de las edades")
    @GetMapping(path = "/kpideclientes")
    public ResponseEntity<PromedioResponse> kpideclientes() {
        try {
            return new ResponseEntity<PromedioResponse>(personService.getPromedio(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
        	throw new GenericException(e.getMessage(), e);
        }
    }

   
}
