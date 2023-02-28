package me.dio.academia.digital.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.infra.utils.AvaliacaoFisicaMapper;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@RequiredArgsConstructor
@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService{
    
    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AvaliacaoFisicaMapper avaliacaoFisicaMapper;

    public AvaliacaoFisica create(AvaliacaoFisicaForm form){
        var avaliacaoFisica = avaliacaoFisicaMapper.toAvaliacaoFisica(form);

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public AvaliacaoFisica get(Long id){
        return avaliacaoFisicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Avaliação física não encontrada"));
    }

    public List<AvaliacaoFisica> getAll(){
        return avaliacaoFisicaRepository.findAll();
    }

    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate){
        var avaliacaoFisica = this.get(id);
        var novaAvaliacaoFisica = avaliacaoFisicaMapper.updateAvaliacaoFisica(formUpdate, avaliacaoFisica);

        return avaliacaoFisicaRepository.save(novaAvaliacaoFisica);
    }

    public void delete(Long id){
        var avaliacaoFisica = this.get(id);
        avaliacaoFisicaRepository.delete(avaliacaoFisica);
    }
}
