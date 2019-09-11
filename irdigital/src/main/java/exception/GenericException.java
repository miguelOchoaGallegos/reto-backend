package exception;

public class GenericException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String rpta;
    private final String mensaje;
    
    public GenericException(String mensaje) {
        super(mensaje);
        this.rpta = "false";
        this.mensaje = mensaje;
    }

    public GenericException(String mensaje, Throwable cause) {
        super(mensaje, cause);
        this.rpta = "false";
        this.mensaje = mensaje;
    }

    public String getRpta() {
        return rpta;
    }

    public String getMensaje() {
        return mensaje;
    }
}
