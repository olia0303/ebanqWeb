package com.ebanq.web.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message, Throwable ex) {
        super(message);
        log.error(message);
        log.error(ex.getMessage());
    }

    public ElementNotFoundException(String message) {
        super(message);
        log.error(message);
    }
}
