package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "TB_FILIAL")
@Data
public class FilialEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_FILIAL")
    private BigInteger cdFilial;

    @Column(name = "NM_FILIAL")
    private String nmFilial;

    @Column(name = "NR_CNPJ")
    private String nrCnpj;

    @Column(name = "NR_TELEFONE")
    private String nrTelefoneFilial;
}
