package me.dio.academia.digital.infra.utils;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.AlunoService;

@RequiredArgsConstructor
@Component
public class MatriculaMapper {
    
    private final AlunoService alunoService;

    public Matricula toMatricula (MatriculaForm form){
        var matricula = new Matricula();
        matricula.setAluno(this.mapAluno(form.getAlunoId()));
        matricula.setDataDaMatricula(LocalDateTime.now());
        
        return matricula;
    }

    private Aluno mapAluno(Long id){
        return alunoService.get(id);
    }


}
