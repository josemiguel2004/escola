package br.com.etec.escola.service;

import br.com.etec.escola.model.Escola;
import br.com.etec.escola.repository.EscolaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public Escola salvar(Escola escola){return escolaRepository.save(escola);}

    public Escola buscarEscolaPorId(Long id){
        Optional<Escola> escolaSalva = escolaRepository.findById(id);

        if(!escolaSalva.isPresent()){
            throw new IllegalArgumentException();
        }

        return escolaSalva.get();
    }

    public Escola atualizar(Long id, Escola escola){
        Escola escolaSalva = buscarEscolaPorId(id);

        BeanUtils.copyProperties(escola,escolaSalva,"id");

        return escolaRepository.save(escolaSalva);
    }
}
