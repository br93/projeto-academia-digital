package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoUpdateForm {

  @NotBlank(message = "Favor preencher o campo nome")
  private String nome;

  @NotBlank(message = "Favor preencher o campo bairro")
  private String bairro;

  @JsonProperty(value = "data_nascimento")
  @NotNull(message = "Favor preencher o campo data de nascimento")
  private LocalDate dataDeNascimento;
}
