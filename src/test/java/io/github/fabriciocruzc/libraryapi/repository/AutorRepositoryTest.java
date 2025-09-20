package io.github.fabriciocruzc.libraryapi.repository;

import io.github.fabriciocruzc.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();

        autor.setNome("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1970, 10, 20));


        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void AtualizarTeste(){
        var id = UUID.fromString("96f31174-25c9-4fd1-800c-51e57bb10362");

        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()){

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1968, 10, 20));

            repository.save(autorEncontrado);
        }

    }

    @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deleteIdTeste(){
        var id = UUID.fromString("96f31174-25c9-4fd1-800c-51e57bb10362");
        repository.deleteById(id);
    }

    @Test
    public void deleteTeste(){
        var id = UUID.fromString("ac64bfb4-3a5b-4854-9192-e298a7ad8a49");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }


}
