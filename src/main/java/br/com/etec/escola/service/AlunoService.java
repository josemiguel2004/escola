package br.com.etec.escola.service;


import br.com.etec.escola.model.Aluno;
import br.com.etec.escola.repository.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno){return alunoRepository.save(aluno);}

    public Aluno buscarAlunoPorId(Long id){
        Optional<Aluno> alunoSalvo = alunoRepository.findById(id);

        if(!alunoSalvo.isPresent()){
            throw new IllegalArgumentException();
        }

        return alunoSalvo.get();
    }

    public Aluno atualizar(Long id, Aluno aluno){
        Aluno alunoSalvo = buscarAlunoPorId(id);

        BeanUtils.copyProperties(aluno, alunoSalvo,"id");

        return alunoRepository.save(alunoSalvo);
    }


}
