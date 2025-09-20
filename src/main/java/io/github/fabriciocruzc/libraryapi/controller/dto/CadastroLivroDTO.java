package io.github.fabriciocruzc.libraryapi.controller.dto;

import io.github.fabriciocruzc.libraryapi.model.GeneroLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDTO(
        @ISBN
        @NotBlank(message = "campo obrigatorio!")
        String isbn,
        @NotBlank(message = "campo obrigatorio!")
        String titulo,
        LocalDate dataPublicacao,
        GeneroLivro genero,
        BigDecimal preco,
        @NotNull(message = "campo obrigatorio!")
        UUID idAutor) {
}
