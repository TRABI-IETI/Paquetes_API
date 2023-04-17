package edu.eci.ieti.paquetes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PackageNotFoundException extends ResponseStatusException {

    public PackageNotFoundException(String id){
        super(HttpStatus.NOT_FOUND, "Package with id: " + id + "not found");
    }
}
