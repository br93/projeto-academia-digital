package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.entity.form.AlunoView;
import me.dio.academia.digital.service.impl.AlunoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody AlunoForm form){
        return new ResponseEntity<>(alunoService.create(form), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AlunoView>> getAll(){
        return new ResponseEntity<>(alunoService.getAllView(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoView> get(@PathVariable Long id){
        return new ResponseEntity<>(alunoService.getView(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        alunoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody AlunoUpdateForm form){
        return new ResponseEntity<>(alunoService.update(id, form), HttpStatus.OK);
    }
    
}
