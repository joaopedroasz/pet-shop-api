package br.com.api.utils;

import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class HttpResponse<T> {

    public ResponseEntity<T> ok(@Nullable T entity) {
        return new ResponseEntity<T>(entity, HttpStatus.ACCEPTED);
    }

    public ResponseEntity error() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
