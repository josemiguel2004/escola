package br.com.etec.escola.resource;

import br.com.etec.escola.model.Estado;
import br.com.etec.escola.repository.EstadoRepository;
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
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping("/todos")
    public List<Estado> listarTodosEstados(){return estadoRepository.findAll(Sort.by("nome").ascending());}

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPeloCodigo(@PathVariable Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.isPresent() ? ResponseEntity.ok(estado.get()) : ResponseEntity.notFound().build();
    }
}
