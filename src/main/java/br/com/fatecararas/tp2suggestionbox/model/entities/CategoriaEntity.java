package br.com.fatecararas.tp2suggestionbox.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categorias")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String descricao;
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<SugestaoEntity> sugestoes = new ArrayList<>();
}
