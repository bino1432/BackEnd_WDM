package net.weg.wdm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoUsuario {

    USUARIO("Usuario"),
    ADMINISTRADOR("Adiministrador");

    private final String NOME;
}
