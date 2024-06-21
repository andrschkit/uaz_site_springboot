package org.example.exceptions;

public abstract class BasicException extends RuntimeException{
    protected String  entityInfo;
    public BasicException(String message) {
        super(message);
    }

    public abstract String getErrorMessage();

    public String getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(String entityInfo) {
        this.entityInfo = entityInfo;
    }
}
