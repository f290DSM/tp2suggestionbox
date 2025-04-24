package br.com.fatecararas.tp2suggestionbox.resources;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.tp2suggestionbox.dto.CategoriaDTO;
import br.com.fatecararas.tp2suggestionbox.services.CategoriaService;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;
    
    // @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody CategoriaDTO dto) {
        System.out.println("DTO recebido.");
        System.out.println(dto);
        try {
            service.salvar(dto);
            throw new Exception("Erro ao salvar categoria.");
            // return ResponseEntity.status(HttpStatus.CREATED).body(dto); 
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }        
    }
}
