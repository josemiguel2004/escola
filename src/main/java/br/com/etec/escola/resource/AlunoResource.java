package br.com.etec.escola.resource;

import br.com.etec.escola.model.Aluno;
import br.com.etec.escola.repository.AlunoRepository;
import br.com.etec.escola.service.AlunoService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/todos")
    public List<Aluno> listarTodosAlunos(){return alunoRepository.findAll(Sort.by("nome").ascending());}


    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPeloCodigo(@PathVariable Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.isPresent() ? ResponseEntity.ok(aluno.get()) : ResponseEntity.notFound().build();

    }

    @PostMapping()
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno, HttpServletResponse response){
        Aluno alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){alunoRepository.deleteById(id);}

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno){
        Aluno alunoSalvo = alunoService.atualizar(id, aluno);

        return ResponseEntity.ok(alunoSalvo);

    }
}
