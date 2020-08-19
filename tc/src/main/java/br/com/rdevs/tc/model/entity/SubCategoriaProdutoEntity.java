package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name="TB_SUB_CATEGORIA_PRODUTO")
public class SubCategoriaProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_SUB_CATEGORIA")
    private BigInteger idSubCategoria;

    @Column(name="DS_SUB_CATEGORIA")
    private String dsSubCategoria;
}
