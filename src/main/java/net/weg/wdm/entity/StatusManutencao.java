package net.weg.wdm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusManutencao {

    EM_MANUTENCAO("Em Manutenção"),
    CONCLUIDA("Concluida");

    private final String NOME;
}
