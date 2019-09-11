package service;

import java.util.List;
import java.util.Map;

import com.miguelo.irdigital.dto.PersonRequest;
import com.miguelo.irdigital.dto.PersonResponse;
import com.miguelo.irdigital.dto.PromedioResponse;

public interface PersonService {
	public Map<String, Object> save(PersonRequest request);
	public List<PersonResponse> getAll();
	public PromedioResponse getPromedio();
}
