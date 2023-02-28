package me.dio.academia.digital.entity.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvaliacaoFisicaForm {

  @NotBlank(message = "Favor preencher id de aluno")
  @JsonProperty(value = "aluno_id")
  private Long alunoId;

  @DecimalMin(value = "0.1", message = "Favor preencher peso")
  private double peso;

  @DecimalMin(value = "0.1", message = "Favor preencher altura")
  private double altura;
}
