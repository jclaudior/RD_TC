package br.com.rdevs.tc.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReservaItemPK implements Serializable {

    private ReservaEntity reserva;
    private ProdutoEntity produto;
}
