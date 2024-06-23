package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.exception;

public class SucursalServiceException extends RuntimeException {
    public SucursalServiceException(String message) {
        super(message);
    }

    public SucursalServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
