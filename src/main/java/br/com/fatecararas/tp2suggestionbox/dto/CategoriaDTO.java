package br.com.fatecararas.tp2suggestionbox.dto;

import br.com.fatecararas.tp2suggestionbox.model.entities.CategoriaEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private Integer id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    public CategoriaDTO(CategoriaEntity entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
    }

}
