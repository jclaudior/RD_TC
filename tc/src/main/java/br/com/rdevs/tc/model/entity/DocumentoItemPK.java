package br.com.rdevs.tc.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class DocumentoItemPK implements Serializable {

    private DocumentoFiscalEntity documentoFiscal;
    private BigInteger numItemDocumento;
}
