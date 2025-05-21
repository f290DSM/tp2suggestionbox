package br.com.fatecararas.tp2suggestionbox.core.config.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApiError {
    public List<String> errors = new ArrayList<>();
    public String path;
    public String date = LocalDateTime.now().toString();

    public ApiError(Exception rne, String path) {
        this.errors = Collections.singletonList(rne.getMessage());
        this.path = path;
    }
}
