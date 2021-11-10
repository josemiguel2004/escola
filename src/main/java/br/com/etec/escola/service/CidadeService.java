package br.com.etec.escola.service;

import br.com.etec.escola.model.Cidade;
import br.com.etec.escola.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade){return cidadeRepository.save(cidade);}
}
