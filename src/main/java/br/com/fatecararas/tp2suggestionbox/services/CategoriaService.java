package br.com.fatecararas.tp2suggestionbox.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.fatecararas.tp2suggestionbox.dto.CategoriaDTO;
import br.com.fatecararas.tp2suggestionbox.model.entities.CategoriaEntity;
import br.com.fatecararas.tp2suggestionbox.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final ModelMapper mapper;

    public CategoriaService(CategoriaRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CategoriaDTO salvar(CategoriaDTO dto) {
        CategoriaEntity entity = mapper.map(dto, CategoriaEntity.class);
        CategoriaEntity saved = repository.save(entity);
        return mapper.map(saved, CategoriaDTO.class);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    public List<CategoriaDTO> buscarTodas() {
        return repository.findAll()
                .stream()
                .map( c -> mapper.map(c, CategoriaDTO.class))
                .toList();
    }

    public CategoriaDTO buscarPorId(Integer id) {
        Optional<CategoriaEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return mapper.map(optional.get(), CategoriaDTO.class);
        }
        throw new RuntimeException("Categoria não encontrada");
    }
}
