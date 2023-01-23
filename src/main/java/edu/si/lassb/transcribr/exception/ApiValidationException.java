package edu.si.lassb.transcribr.exception;

public class ApiValidationException extends ApiSubException {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiValidationException() {}

    public ApiValidationException(String object, String message) {
        this.object = object;
        this.message = message;
    }

    public ApiValidationException(String object, String message, Object rejectedValue, String field) {
        this.object = object;
        this.message = message;
        this.rejectedValue = rejectedValue;
        this.field = field;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
