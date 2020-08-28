package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "TB_STATUS_PRODUTO")
@Data
public class StatusProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS_PRODUTO")
    private BigInteger idStatusProduto;

    @Column(name = "DS_STATUS_PRODUTO")
    private String dsStatusProduto;
}
