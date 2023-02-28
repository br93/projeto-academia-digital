package me.dio.academia.digital.controller;

import java.util.List;

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
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/avaliacoes")
public class AvaliacaoFisicaController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@RequestBody AvaliacaoFisicaForm form){
        return new ResponseEntity<>(avaliacaoFisicaService.create(form), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> getAll(){
        return new ResponseEntity<>(avaliacaoFisicaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AvaliacaoFisica> get(@PathVariable Long id){
        return new ResponseEntity<>(avaliacaoFisicaService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        avaliacaoFisicaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm form){
        return new ResponseEntity<>(avaliacaoFisicaService.update(id, form), HttpStatus.OK);
    }
}
