package io.github.fabriciocruzc.libraryapi.controller.mappers;

import io.github.fabriciocruzc.libraryapi.controller.dto.AutorDTO;
import io.github.fabriciocruzc.libraryapi.model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}
