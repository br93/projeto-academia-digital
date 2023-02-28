package me.dio.academia.digital.entity.form;

import javax.validation.constraints.DecimalMin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvaliacaoFisicaUpdateForm {

  @DecimalMin(value = "0.1", message = "Favor preencher peso")
  private double peso;

  @DecimalMin(value = "0.1", message = "Favor preencher altura")
  private double altura;
}
