package br.com.fatecararas.tp2suggestionbox.resources;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloResource {

    @GetMapping("/{nome}")
    public ResponseEntity<String> hello(@PathVariable("nome") String nome) {
        return ResponseEntity.ok("Hello " + nome);
    }

    @GetMapping("/soma/{a}/{b}")
    public ResponseEntity<Integer> soma(@PathVariable("a") Integer a,
            @PathVariable("b") Integer b) {
        return ResponseEntity.ok(a + b);
    }

    @GetMapping("/soma")
    public ResponseEntity<Integer> soma2(@RequestParam("a") Integer a,
            @RequestParam("b") Integer b) {
        return ResponseEntity.ok(a + b);
    }

}
