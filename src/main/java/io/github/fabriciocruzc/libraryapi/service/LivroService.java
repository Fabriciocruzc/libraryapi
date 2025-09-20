package io.github.fabriciocruzc.libraryapi.service;

import io.github.fabriciocruzc.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.fabriciocruzc.libraryapi.controller.dto.ErroResposta;
import io.github.fabriciocruzc.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.fabriciocruzc.libraryapi.model.GeneroLivro;
import io.github.fabriciocruzc.libraryapi.model.Livro;
import io.github.fabriciocruzc.libraryapi.repository.LivroRepository;
import io.github.fabriciocruzc.libraryapi.repository.specs.LivroSpecs;
import io.github.fabriciocruzc.libraryapi.validator.LivroValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroValidator validator;

    public Livro salvar(Livro livro) {
        validator.validar(livro);
        return livroRepository.save(livro);
    }

    public Optional<Livro> obterPorId(UUID id){
        return  livroRepository.findById(id);
    }

    public void deletar(Livro livro){
        livroRepository.delete(livro);
    }

    public Page<Livro> pesquisa(String isbn, String nomeAutor, String titulo, GeneroLivro genero, Integer anoPublicacao, Integer pagina, Integer tamanhoPagina){

        Specification<Livro> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if(isbn != null){
            specs = specs.and(LivroSpecs.isbnEqual(isbn));
        }

        if(titulo != null){
            specs = specs.and(LivroSpecs.tituloLike(titulo));
        }

        if(genero != null){
            specs = specs.and(LivroSpecs.generoEqual(genero));
        }

        if(anoPublicacao != null){
            specs = specs.and(LivroSpecs.anoPublicacaoEqual(anoPublicacao));
        }

        if(nomeAutor != null){
            specs = specs.and(LivroSpecs.nomeAutorLike(nomeAutor));
        }

        Pageable pageRequest = PageRequest.of(pagina, tamanhoPagina);

        return livroRepository.findAll(specs, pageRequest);
    }


    public void atualizar(Livro livro) {
        if(livro.getId() == null){
            throw new IllegalArgumentException("Para atualizar, é necessario que o livro já esteja cadastradi!");
        }
        validator.validar(livro);
        livroRepository.save(livro);
    }
}
