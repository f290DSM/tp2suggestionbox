package br.com.fatecararas.tp2suggestionbox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.tp2suggestionbox.dto.CategoriaDTO;
import br.com.fatecararas.tp2suggestionbox.model.entities.CategoriaEntity;
import br.com.fatecararas.tp2suggestionbox.repositories.CategoriaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaDTO salvar(CategoriaDTO dto) {
        var categoria = new CategoriaEntity(null, dto.getDescricao(), List.of());
        CategoriaEntity entity = repository.save(categoria);
        return new CategoriaDTO(entity);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    public List<CategoriaDTO> buscarTodas() {
        return repository.findAll()
                .stream()
                .map(CategoriaDTO::new)
                .toList();
    }

    public CategoriaDTO buscarPorId(Integer id) {
        Optional<CategoriaEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return new CategoriaDTO(optional.get());
        }
        throw new RuntimeException("Categoria não encontrada");
    }
}
