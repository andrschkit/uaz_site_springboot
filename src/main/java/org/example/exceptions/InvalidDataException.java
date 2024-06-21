package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataException extends BasicException {
    private String extraEntityInfo;

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(
            String message,
            String  entityInfo) {
        super(message);
        this.entityInfo = entityInfo;
    }

    public InvalidDataException(
            String message,
            String  entityInfo,
            String extraEntityInfo) {
        super(message);
        this.entityInfo = entityInfo;
        this.extraEntityInfo = extraEntityInfo;
    }

    public String getErrorMessage(){
        return getMessage() +" : \n\r"+ getEntityInfo()+ " : \n\r" + getExtraEntityInfo();
    }

    public String getExtraEntityInfo() {
        return extraEntityInfo;
    }

    public void setExtraEntityInfo(String extraEntityInfo) {
        this.extraEntityInfo = extraEntityInfo;
    }
}
