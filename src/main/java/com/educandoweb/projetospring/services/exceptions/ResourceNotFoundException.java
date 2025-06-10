package com.educandoweb.projetospring.services.exceptions;

import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id = "+ id);
    }
}
