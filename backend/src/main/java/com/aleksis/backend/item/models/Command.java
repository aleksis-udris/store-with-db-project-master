package com.aleksis.backend.item.models;

import org.springframework.http.ResponseEntity;

public interface Command <I, O>{
    ResponseEntity<O> execute(I input);
}
