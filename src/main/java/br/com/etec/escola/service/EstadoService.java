package br.com.etec.escola.service;

import br.com.etec.escola.model.Estado;
import br.com.etec.escola.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){return estadoRepository.save(estado);}
}
