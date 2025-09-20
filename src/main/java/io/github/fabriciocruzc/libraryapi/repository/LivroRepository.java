package io.github.fabriciocruzc.libraryapi.repository;

import io.github.fabriciocruzc.libraryapi.model.Autor;
import io.github.fabriciocruzc.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID>, JpaSpecificationExecutor<Livro> {
    List<Livro> findByAutor(Autor autor);

    boolean existsByAutor(Autor autor);

    Optional<Livro> findByIsbn(String isbn);
}
