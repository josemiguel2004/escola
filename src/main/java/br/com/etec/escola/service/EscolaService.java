package br.com.etec.escola.service;

import br.com.etec.escola.model.Escola;
import br.com.etec.escola.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public Escola salvar(Escola escola){return escolaRepository.save(escola);}
}
