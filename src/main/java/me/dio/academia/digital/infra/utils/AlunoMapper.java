package me.dio.academia.digital.infra.utils;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AlunoView;

@RequiredArgsConstructor
@Component
public class AlunoMapper {

    public Aluno toAluno(AlunoForm form){
        var aluno = new Aluno();
        
        aluno.setBairro(form.getBairro());
        aluno.setCpf(form.getCpf());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        aluno.setNome(form.getNome());

        return aluno;
    }

    public Aluno updateAluno(AlunoUpdateForm form, Aluno aluno){
       
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());
        aluno.setNome(form.getNome());
        
        return aluno;
    }

    public AlunoView toAlunoView(Aluno aluno){
        var alunoView = new AlunoView();

        alunoView.setBairro(aluno.getBairro());
        alunoView.setCpf(aluno.getCpf());
        alunoView.setDataDeNascimento(aluno.getDataDeNascimento());
        alunoView.setId(aluno.getId());
        alunoView.setNome(aluno.getNome());
        alunoView.setTemAvaliacaoFisica(this.mapTemAvaliacaoFisica(aluno));

        return alunoView;

    }

    private Boolean mapTemAvaliacaoFisica(Aluno aluno){
        return !aluno.getAvaliacoes().isEmpty();
    }


    
}
