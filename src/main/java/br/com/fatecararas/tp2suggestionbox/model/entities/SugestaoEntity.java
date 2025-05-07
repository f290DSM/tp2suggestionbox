package br.com.fatecararas.tp2suggestionbox.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sugestoes")
public class SugestaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 500)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;
}
