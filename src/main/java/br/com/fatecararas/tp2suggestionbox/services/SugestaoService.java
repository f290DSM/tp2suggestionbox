package br.com.fatecararas.tp2suggestionbox.services;

import br.com.fatecararas.tp2suggestionbox.dto.SugestaoDTO;
import br.com.fatecararas.tp2suggestionbox.model.entities.SugestaoEntity;
import br.com.fatecararas.tp2suggestionbox.repositories.SugestaoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SugestaoService {
    private final SugestaoRepository repository;
    private final ModelMapper mapper;

    public SugestaoDTO salvar(SugestaoDTO dto) {
        SugestaoEntity entity = mapper.map(dto, SugestaoEntity.class);
        SugestaoEntity saved = repository.save(entity);
        return mapper.map(saved, SugestaoDTO.class);
    }
}
