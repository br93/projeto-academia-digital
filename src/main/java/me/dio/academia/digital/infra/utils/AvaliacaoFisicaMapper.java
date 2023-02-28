package me.dio.academia.digital.infra.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AlunoService;

@RequiredArgsConstructor
@Component
public class AvaliacaoFisicaMapper {

    private final AlunoService alunoService;
    
    public AvaliacaoFisica toAvaliacaoFisica (AvaliacaoFisicaForm form){
        var avaliacaoFisica = new AvaliacaoFisica();
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setAluno(this.mapAluno(form.getAlunoId()));
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setDataDaAvaliacao(LocalDateTime.now());


        return avaliacaoFisica;
    }

    public AvaliacaoFisica updateAvaliacaoFisica (AvaliacaoFisicaUpdateForm form, AvaliacaoFisica avaliacaoFisica){
        avaliacaoFisica.setAltura(form.getAltura());
        avaliacaoFisica.setPeso(form.getPeso());

        return avaliacaoFisica;
    }

    private Aluno mapAluno(Long id){
        return alunoService.get(id);
    }
}
