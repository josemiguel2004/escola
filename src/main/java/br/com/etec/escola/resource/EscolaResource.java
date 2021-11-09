package br.com.etec.escola.resource;

import br.com.etec.escola.model.Escola;
import br.com.etec.escola.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escolas")
public class EscolaResource {

    @Autowired
    private EscolaRepository escolaRepository;

    @GetMapping("/todas")
    public List<Escola> listarTodasEscolas() { return escolaRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Escola> buscarPeloCodigo(@PathVariable Long id){
        Optional<Escola> escola = escolaRepository.findById(id);
        return escola.isPresent() ? ResponseEntity.ok(escola.get()) : ResponseEntity.notFound().build();
    }
}
