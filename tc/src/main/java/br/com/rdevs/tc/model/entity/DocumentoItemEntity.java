package br.com.rdevs.tc.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_DOCUMENTO_ITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(DocumentoItemEntity.class)
public class DocumentoItemEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCUMENTO_FISCAL")
    @JsonIgnore
    @Id
    private DocumentoFiscalEntity idDocumentoFiscal;

    @Id
    @Column(name = "NR_ITEM_DOCUMENTO")
    private Long numItemDocumento;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;

    @Column (name = "QT_ITEM")
    private Integer qtdItem;

    @Column (name = "PC_ICMS")
    private Double porcentoIcms;

    @Column (name = "VL_ICMS")
    private Double valorIcms;

    @Column (name = "VL_ITEM")
    private Double valorItem;

}
