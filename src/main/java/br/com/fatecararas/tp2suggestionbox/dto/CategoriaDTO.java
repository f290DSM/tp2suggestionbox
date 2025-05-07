package br.com.fatecararas.tp2suggestionbox.dto;

import br.com.fatecararas.tp2suggestionbox.model.entities.CategoriaEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private Integer id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    private List<SugestaoDTO> sugestoes = new ArrayList<>();

    public CategoriaDTO(CategoriaEntity entity) {
        this.id = entity.getId();
        this.descricao = entity.getDescricao();
        this.sugestoes = entity.getSugestoes()
                .stream()
                .map(SugestaoDTO::new)
                .toList();
    }

}
