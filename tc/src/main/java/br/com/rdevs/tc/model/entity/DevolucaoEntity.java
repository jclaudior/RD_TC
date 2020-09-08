package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_DEVOLUCAO")
@Data
public class DevolucaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEVOLUCAO")
    private BigInteger idDevolucao;

    @Column(name = "ID_DOCUMENTO_FISCAL")
    //@OneToOne
    //@JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    private BigInteger documentoFiscal;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity cliente;

    @Column(name = "VL_DEVOLUCAO")
    private Double vlDevolucao;

    @OneToOne
    @JoinColumn(name = "ID_TIPO_PAGAMENTO")
    private TipoPagamentoEntity tipoPagamento;

    @Column(name = "NR_ITEM_DOCUMENTO")
    private BigInteger nrItemDocumento;
}
