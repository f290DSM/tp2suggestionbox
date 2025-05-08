package br.com.fatecararas.tp2suggestionbox.repositories;

import br.com.fatecararas.tp2suggestionbox.model.entities.SugestaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestaoRepository
        extends JpaRepository<SugestaoEntity, Integer> {
}
