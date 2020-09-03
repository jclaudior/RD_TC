package br.com.rdevs.tc.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_PAGAMENTO_DOC")
@Data
public class PagamentoDocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private BigInteger idPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    @JsonIgnore
    private DocumentoFiscalEntity documentoFiscal;

    @Column(name = "VL_PAGAMENTO")
    private Double vlPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PAGAMENTO")
    private TipoPagamentoEntity tipoPagamento;
}
