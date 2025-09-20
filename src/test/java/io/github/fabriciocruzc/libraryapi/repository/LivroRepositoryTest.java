package io.github.fabriciocruzc.libraryapi.repository;

import io.github.fabriciocruzc.libraryapi.model.Autor;
import io.github.fabriciocruzc.libraryapi.model.GeneroLivro;
import io.github.fabriciocruzc.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class LivroRepositoryTest {
    @Autowired
    AutorRepository repository;
    @Autowired
    LivroRepository livroRepository;

    @Test
    void salvarLivro(){
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setTitulo("Ciencia");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        Autor autor = repository.findById(UUID.fromString("67a819d0-e807-4ef6-8b76-f52996d53127")).orElse(null);

        livro.setAutor(autor);

        livroRepository.save(livro);
    }

}
