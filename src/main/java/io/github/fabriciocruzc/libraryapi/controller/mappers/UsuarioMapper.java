package io.github.fabriciocruzc.libraryapi.controller.mappers;

import io.github.fabriciocruzc.libraryapi.controller.dto.UsuarioDTO;
import io.github.fabriciocruzc.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
