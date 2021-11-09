package br.com.etec.escola.resource;

import br.com.etec.escola.model.Escola;
import br.com.etec.escola.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaResource {

    @Autowired
    private EscolaRepository escolaRepository;

    @GetMapping("/todas")
    public List<Escola> listarTodasEscolas() { return escolaRepository.findAll(Sort.by("nome").ascending());}
}
