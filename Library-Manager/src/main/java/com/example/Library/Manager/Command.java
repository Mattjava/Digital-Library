package com.example.Library.Manager;

import org.springframework.http.ResponseEntity;

public interface Command<I, O> {

    public ResponseEntity<O> run(I input);
}
