package br.com.etec.escola.resource;

import br.com.etec.escola.model.Escola;
import br.com.etec.escola.repository.EscolaRepository;
import br.com.etec.escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escolas")
public class EscolaResource {

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private EscolaService escolaService;

    @GetMapping("/todas")
    public List<Escola> listarTodasEscolas() { return escolaRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Escola> buscarPeloCodigo(@PathVariable Long id){
        Optional<Escola> escola = escolaRepository.findById(id);
        return escola.isPresent() ? ResponseEntity.ok(escola.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Escola> criar(@RequestBody Escola escola, HttpServletResponse response){
        Escola escolaSalva = escolaService.salvar(escola);
        return ResponseEntity.status(HttpStatus.CREATED).body(escolaSalva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){escolaRepository.deleteById(id);}

    @PutMapping("/{id}")
    public ResponseEntity<Escola> atualizar(@PathVariable Long id,@RequestBody Escola escola){
        Escola escolaSalva = escolaService.atualizar(id, escola);

        return ResponseEntity.ok(escolaSalva);
    }
}
