package br.com.fatecararas.tp2suggestionbox.resources;

import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fatecararas.tp2suggestionbox.dto.CategoriaDTO;
import br.com.fatecararas.tp2suggestionbox.services.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;
    
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@Valid @RequestBody CategoriaDTO dto) {
        
        try {
            service.salvar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }        
    }

    @GetMapping("/todas")
    public ResponseEntity<?> buscarTodas() {
        List<CategoriaDTO> categorias = service.buscarTodas();
        if  (categorias.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma categoria encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id) {
        try {
            service.excluir(id);
            return ResponseEntity.status(HttpStatus.OK).body("Categoria excluída com sucesso");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
