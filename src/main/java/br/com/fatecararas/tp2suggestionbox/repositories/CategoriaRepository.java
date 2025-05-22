package br.com.fatecararas.tp2suggestionbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.tp2suggestionbox.model.entities.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    CategoriaEntity findByDescricaoContainsIgnoreCase(String descricao);
}
