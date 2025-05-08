package br.com.fatecararas.tp2suggestionbox.dto;

import br.com.fatecararas.tp2suggestionbox.model.entities.SugestaoEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SugestaoDTO {

    private Integer id;
    @NotNull(message = "O campo descrição não pode ser nulo")
    @Size(max = 500)
    private String descricao;
    @NotNull(message = "O campo categoria não pode ser nulo")
    private CategoriaDTO categoria;

//    public SugestaoDTO(SugestaoEntity entity) {
//        this.id = entity.getId();
//        this.descricao = entity.getDescricao();
//        this.categoria = new CategoriaDTO(entity.getCategoria());
//    }
}
