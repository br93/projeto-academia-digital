package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AlunoView;
import me.dio.academia.digital.infra.utils.AlunoMapper;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@RequiredArgsConstructor
@Service
public class AlunoService implements IAlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public Aluno create(AlunoForm form) {
        var aluno = alunoMapper.toAluno(form);

        return alunoRepository.save(aluno);
    }

    public Aluno get(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public AlunoView getView(Long id) {
        return alunoMapper.toAlunoView(this.get(id));
    }

    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    public List<AlunoView> getAllView(){
        return this.getAll().stream().map(alunoMapper::toAlunoView).collect(Collectors.toList());
    }

    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        var aluno = this.get(id);
        var novoAluno = alunoMapper.updateAluno(formUpdate, aluno);

        return alunoRepository.save(novoAluno);
    }

    public void delete(Long id) {
        var aluno = this.get(id);
        alunoRepository.delete(aluno);
    }

}
