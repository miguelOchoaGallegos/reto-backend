package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.miguelo.irdigital.dto.ErrorResponse;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler({GenericException.class})
    public @ResponseBody
    ErrorResponse handleException(Exception ex) {
        ErrorResponse response = new ErrorResponse();        
        response.setRpta(Boolean.FALSE.toString());
        response.setMensaje(ex.getMessage());
        return response;
    }
}
