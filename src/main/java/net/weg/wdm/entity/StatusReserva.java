package net.weg.wdm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusReserva {

    EM_ABERTO("Em Aberto"),
    AGUARDANDO_RETIRADA("Aguardando Retirada"),
    AGUARDANDO_DEVOLUCAO("Aguardando Devolução"),
    ATRASADA("Atrasada"),
    CONCLUIDA("Concluida"),
    CANCELADA("Cancelada");

    private final String NOME;
}
