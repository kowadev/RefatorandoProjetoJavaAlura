package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.excpetion.ValidacaoExcpetion;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public Tutor criarTutor(Tutor tutor){
        boolean jaCadastrado = repository.existsByTelefone(tutor.getTelefone()) || repository.existsByEmail(tutor.getEmail());
        if(jaCadastrado){
            throw new ValidacaoExcpetion("Dados já cadastrados");
        }
        return repository.save(tutor);
    }
}
