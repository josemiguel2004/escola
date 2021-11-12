package br.com.etec.escola.resource;


import br.com.etec.escola.model.Cidade;
import br.com.etec.escola.repository.CidadeRepository;
import br.com.etec.escola.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/todas")
    public List<Cidade> listarTodasCidades(){return cidadeRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPeloCodigo(@PathVariable Long id){
        Optional<Cidade> cidade = cidadeRepository.findById(id);
        return cidade.isPresent() ? ResponseEntity.ok(cidade.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Cidade> criar(@RequestBody Cidade cidade, HttpServletResponse response){
        Cidade cidadeSalva = cidadeService.salvar(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){cidadeRepository.deleteById(id);}
}
