package org.greenGroup.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super(String.format("User with id = %d not found.", id));
    }
}
