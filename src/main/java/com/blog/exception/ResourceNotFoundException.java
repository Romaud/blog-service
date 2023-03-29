package com.blog.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String user, String id, Long resourceId) {
        super("Resource with id " + resourceId + " not found");
    }
}
