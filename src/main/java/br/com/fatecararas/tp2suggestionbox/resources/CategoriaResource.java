package br.com.fatecararas.tp2suggestionbox.resources;

import br.com.fatecararas.tp2suggestionbox.core.config.exceptions.RecursoNaoEncontradoException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fatecararas.tp2suggestionbox.dto.CategoriaDTO;
import br.com.fatecararas.tp2suggestionbox.services.CategoriaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(name = "Categorias", description = "Endpoints para gerenciamento de categorias.")
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaResource {

    private final CategoriaService service;

    public CategoriaResource(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody CategoriaDTO dto) {
        try {
            CategoriaDTO categoria = service.salvar(dto);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(categoria.getId())
                    .toUri();

            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(description = "Listar todas as categorias cadastradas na base de dados da API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todas as categorias cadastradas"),
            @ApiResponse(responseCode = "404", description = "Nenhuma categoria encontrada")
    })
    @GetMapping
    public List<CategoriaDTO> buscarTodas() throws RecursoNaoEncontradoException {
        return service.buscarTodas();
    }

    @Operation(description = "Excluir uma categoria cadastrada na base de dados da API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoria excluída com sucesso"),
            @ApiResponse(responseCode = "422", description = "Requisição não pode ser processada.")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) throws RecursoNaoEncontradoException {
        service.excluir(id);
    }

    @Operation(description = "Buscar uma categoria cadastrada na base de dados da API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria encontrada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @GetMapping("/{id}")
    public CategoriaDTO buscarPorId(@PathVariable Integer id) throws RecursoNaoEncontradoException {
        return service.buscarPorId(id);
    }

    //TODO: Editar Categoria
    @Operation(description = "Editar uma categoria cadastrada na base de dados da API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria editada"),
            @ApiResponse(responseCode = "422", description = "Categoria não pode ser editada")
    })
    @PutMapping("/editar")
    public CategoriaDTO editar(@Valid @RequestBody CategoriaDTO dto) throws Exception {
        return service.editar(dto);
    }

    //TODO: Buscar por descrição
    @Operation(description = "Buscar uma categoria cadastrada na base de dados da API pela descrição.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria encontrada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @GetMapping("/buscar")
    public CategoriaDTO buscarPorDescricao(@RequestParam String descricao) throws RecursoNaoEncontradoException {
        return service.buscarPorDescricao(descricao);
    }
}
