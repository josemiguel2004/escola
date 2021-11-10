package br.com.etec.escola.service;


import br.com.etec.escola.model.Aluno;
import br.com.etec.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){return alunoRepository.save(aluno);}


}
