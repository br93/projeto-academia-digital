package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoForm {

  @NotBlank(message = "Favor preencher o campo nome")
  private String nome;

  @NotBlank(message = "Favor preencher o campo cpf")
  @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$", message = "Favor preencher no formato apropriado 000.000.000-00")
  private String cpf;

  @NotBlank(message = "Favor preencher o campo bairro")
  private String bairro;

  @JsonProperty(value = "data_nascimento")
  @NotNull(message = "Favor preencher o campo data de nascimento")
  private LocalDate dataDeNascimento;
}
