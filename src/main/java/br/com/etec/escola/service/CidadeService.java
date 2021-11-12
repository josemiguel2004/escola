package br.com.etec.escola.service;

import br.com.etec.escola.model.Cidade;
import br.com.etec.escola.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade){return cidadeRepository.save(cidade);}

    public Cidade buscarCidadePorId(Long id){
        Optional<Cidade> cidadeSalva = cidadeRepository.findById(id);

        if(!cidadeSalva.isPresent()){
            throw new IllegalArgumentException();
        }

        return cidadeSalva.get();
    }

    public Cidade atualizar(Long id, Cidade cidade){
        Cidade cidadeSalva = buscarCidadePorId(id);

        BeanUtils.copyProperties(cidade, cidadeSalva,"id");

        return cidadeRepository.save(cidadeSalva);
    }
}
