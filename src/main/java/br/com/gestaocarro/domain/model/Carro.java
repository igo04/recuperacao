package br.com.gestaocarro.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Loja")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID carroId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private float preco;
}
