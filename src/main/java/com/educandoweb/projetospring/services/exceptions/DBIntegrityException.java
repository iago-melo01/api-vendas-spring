package com.educandoweb.projetospring.services.exceptions;

import java.io.Serializable;

public class DBIntegrityException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;
    public DBIntegrityException(String msg){
        super(msg);
    }
}
