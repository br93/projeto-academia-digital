package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.infra.utils.MatriculaMapper;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;

@RequiredArgsConstructor
@Service
public class MatriculaService implements IMatriculaService{
    
    private final MatriculaRepository matriculaRepository;
    private final MatriculaMapper matriculaMapper;

    public Matricula create(MatriculaForm form){
        var matricula = matriculaMapper.toMatricula(form);

        return matriculaRepository.save(matricula);
    }

    public Matricula get(Long id){
        return matriculaRepository.findById(id).orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));
    }

    public List<Matricula> getAll(){
        return matriculaRepository.findAll();
    }

    public void delete(Long id){
        var matricula = this.get(id);
        matriculaRepository.delete(matricula);
    }
}
