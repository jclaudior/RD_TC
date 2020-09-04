package br.com.rdevs.tc.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_DOCUMENTO_FISCAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class
DocumentoFiscalEntity implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO_FISCAL")
    private BigInteger idDocumentoFiscal;

    @JoinColumn(name = "CD_OPERACAO")
    @ManyToOne
    private OperacaoEntity operacao;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")
    private FilialEntity filial;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity cliente;

    @OneToOne
    @JoinColumn(name = "ID_MOTIVO")
    private MotivoEntity motivoDevolucao;

    @Column(name = "DT_ABERTURA")
    private Date dataAbertura;

    @Column(name = "DT_FECHAMENTO")
    private Date dataFechamento;

    @Column(name = "FL_NF")
    private Integer flagNota;

    @Column(name = "VL_DOCUMENTO_FISCAL")
    private Double valorDocumento;

    @Column(name = "NR_CAIXA")
    private Integer numeroCaixa;

    @OneToMany(mappedBy = "idDocumentoFiscal", cascade = CascadeType.ALL)
    private List<DocumentoItemEntity> itens;

    @Column(name = "FL_NOTA_DEVOLVIDA")
    private  Integer flagNotaDevolvida;
}
