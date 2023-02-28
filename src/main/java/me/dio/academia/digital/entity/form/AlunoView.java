package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoView {

    private Long id;
    private String nome;
    private String cpf;
    private String bairro;

    @JsonProperty(value = "data_nascimento")
    private LocalDate dataDeNascimento;

    @JsonProperty(value = "tem_avaliacao_fisica")
    private Boolean temAvaliacaoFisica;
    
}
