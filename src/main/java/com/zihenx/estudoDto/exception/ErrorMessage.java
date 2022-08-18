package com.zihenx.estudoDto.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private Integer statusCode;
    private OffsetDateTime date;
    private String messageError;
    private List<InfoError> infoError;

    public ErrorMessage(Integer statusCode, OffsetDateTime date, String messageError, List<InfoError> infoError) {
        this.statusCode = statusCode;
        this.date = date;
        this.messageError = messageError;
        this.infoError = infoError;
    }

    public ErrorMessage(Integer statusCode, OffsetDateTime date, String messageError) {
        this.statusCode = statusCode;
        this.date = date;
        this.messageError = messageError;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public List<InfoError> getInfoError() {
        return infoError;
    }

    public void setInfoError(List<InfoError> infoError) {
        this.infoError = infoError;
    }

    public static class InfoError {
        private String fieldError;
        private String errorMessage;

        public InfoError(String fieldError, String errorMessage) {
            this.fieldError = fieldError;
            this.errorMessage = errorMessage;
        }

        public String getFieldError() {
            return fieldError;
        }

        public void setFieldError(String fieldError) {
            this.fieldError = fieldError;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
