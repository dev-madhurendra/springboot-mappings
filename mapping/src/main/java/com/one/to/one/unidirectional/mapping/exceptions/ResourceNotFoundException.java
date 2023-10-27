package com.one.to.one.unidirectional.mapping.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String with, Object field) {
        super(resourceName + "with " + with + field +  " not found ");
    }
}
