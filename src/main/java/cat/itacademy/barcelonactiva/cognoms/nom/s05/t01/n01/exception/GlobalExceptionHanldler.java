package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHanldler {
    @ExceptionHandler(SucursalServiceException.class)
    public ResponseEntity<String> handleSucursalServiceException(SucursalServiceException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Error: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Data integrity violation: " + ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<String> handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Invalid data access API usage: " + ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                "An unexpected error occurred: " + ex.getMessage() + request.toString(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
