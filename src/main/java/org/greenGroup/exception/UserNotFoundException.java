package org.greenGroup.exception;

import org.greenGroup.constant.ExceptionConstant;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super(String.format(ExceptionConstant.USER_NOT_FOUND_BY_ID, id));
    }
}
