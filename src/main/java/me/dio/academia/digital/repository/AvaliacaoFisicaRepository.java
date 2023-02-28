package me.dio.academia.digital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;

public interface AvaliacaoFisicaRepository extends JpaRepository<AvaliacaoFisica, Long>{

    Optional<AvaliacaoFisica> findByAluno(Aluno aluno);
}
