package br.com.etec.escola.service;

import br.com.etec.escola.model.Estado;
import br.com.etec.escola.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){return estadoRepository.save(estado);}

    public Estado buscarEstadoPorId(Long id){
        Optional<Estado> estadoSalvo = estadoRepository.findById(id);

        if(!estadoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }
        return estadoSalvo.get();
    }

    public Estado atualizar(Long id, Estado estado){
        Estado estadoSalvo = buscarEstadoPorId(id);

        BeanUtils.copyProperties(estado,estadoSalvo,"id");

        return estadoRepository.save(estadoSalvo);
    }
}
