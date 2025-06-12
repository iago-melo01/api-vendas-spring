package com.educandoweb.projetospring.resources.exceptions;

import com.educandoweb.projetospring.services.exceptions.DBIntegrityException;
import com.educandoweb.projetospring.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // é uma annotation que permite definir a todos os seus controllers
// como tratar exceções
public class ResourceExceptionHandler  {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError ste = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()  );
        return ResponseEntity.status(status).body(ste);
    }

    @ExceptionHandler(DBIntegrityException.class)
    public ResponseEntity<StandardError> databaseIntegrityViolated(DBIntegrityException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        String error = "Database Integrity Violated";
        StandardError ste = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI() );
        return ResponseEntity.status(status).body(ste);
    }
}
