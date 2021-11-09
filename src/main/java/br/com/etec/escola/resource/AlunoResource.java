package br.com.etec.escola.resource;

import br.com.etec.escola.model.Aluno;
import br.com.etec.escola.repository.AlunoRepository;
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
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/todos")
    public List<Aluno> listarTodosAlunos(){return alunoRepository.findAll(Sort.by("nome").ascending());}


    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPeloCodigo(@PathVariable Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.isPresent() ? ResponseEntity.ok(aluno.get()) : ResponseEntity.notFound().build();

    }
}
