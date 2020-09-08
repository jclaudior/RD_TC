package br.com.rdevs.tc.model.dto;

import br.com.rdevs.tc.model.entity.ClienteEntity;
import br.com.rdevs.tc.model.entity.DocumentoFiscalEntity;
import br.com.rdevs.tc.model.entity.TipoPagamentoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevolucaoDTO {

    private BigInteger idDevolucao;
    private BigInteger documentoFiscal;
    private ClienteDTO cliente;
    private Double vlDevolucao;
    private TipoPagamentoDTO tipoPagamento;

    private BigInteger nrItemDocumento;
}
