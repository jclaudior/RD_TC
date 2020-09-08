package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "TB_TIPO_PAGAMENTO")
@Data
public class TipoPagamentoEntity {

    @Id
    @Column(name = "ID_TIPO_PAGAMENTO")
    private BigInteger idTipoPagamento;

    @Column(name = "DS_TIPO_PAGAMENTO")
    private String dsTipoPagamento;
}
