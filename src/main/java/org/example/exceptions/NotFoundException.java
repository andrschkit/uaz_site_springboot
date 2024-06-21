package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BasicException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, String  entityInfo) {
        super(message);
        this.entityInfo = entityInfo;
    }

    public String getErrorMessage(){
        return getMessage() +" : \n\r"+ getEntityInfo();
    }

}
