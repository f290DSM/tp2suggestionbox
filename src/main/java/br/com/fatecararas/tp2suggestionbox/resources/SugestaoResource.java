package br.com.fatecararas.tp2suggestionbox.resources;

import br.com.fatecararas.tp2suggestionbox.dto.SugestaoDTO;
import br.com.fatecararas.tp2suggestionbox.model.entities.SugestaoEntity;
import br.com.fatecararas.tp2suggestionbox.repositories.SugestaoRepository;
import br.com.fatecararas.tp2suggestionbox.services.SugestaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sugestoes")
public class SugestaoResource {

    private final SugestaoRepository repository;
    private final ModelMapper mapper;

    @PostMapping
    public SugestaoDTO salvar(@Valid @RequestBody SugestaoDTO dto) {
        SugestaoEntity entity = mapper.map(dto, SugestaoEntity.class);
        return mapper.map(repository.save(entity), SugestaoDTO.class);
    }

    @GetMapping
    public List<SugestaoDTO> buscarTodas() {
        return repository.findAll()
                .stream()
                .map( c -> mapper.map(c, SugestaoDTO.class))
                .toList();
    }

    //TODO: Buscar por ID

    //TODO: Exluir

    //TODO: Editar
}
