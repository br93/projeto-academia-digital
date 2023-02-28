package me.dio.academia.digital.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> create(@RequestBody MatriculaForm form){
        return new ResponseEntity<>(matriculaService.create(form), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAll(){
        return new ResponseEntity<>(matriculaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Matricula> get(@PathVariable Long id){
        return new ResponseEntity<>(matriculaService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        matriculaService.delete(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
