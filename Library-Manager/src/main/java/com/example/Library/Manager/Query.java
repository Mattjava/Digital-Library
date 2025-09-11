package com.example.Library.Manager;

import org.springframework.http.ResponseEntity;

public interface Query<I, O>{

    public ResponseEntity<O> run(I input);
}
