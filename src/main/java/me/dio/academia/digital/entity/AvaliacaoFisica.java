package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_avaliacoes_fisica")
public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Aluno aluno;

  @Column(name = "data_avaliacao", columnDefinition = "timestamp default 'now()'")
  private LocalDateTime dataDaAvaliacao;

  @Column(nullable = false)
  private double peso;
  
  @Column(nullable = false)
  private double altura;

}
