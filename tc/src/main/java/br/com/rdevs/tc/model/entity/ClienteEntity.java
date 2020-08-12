package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "TB_CLIENTE")
@Data
public class ClienteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;

    @Column(name = "NM_CLIENTE")
    private String nmCliente;

    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Column(name = "DT_CADASTRO")
    private Date dtCadastro;

    @Column(name = "NR_RG")
    private String nrRg;

    @Column(name = "DT_NASC")
    private Date dtNascimento;

    @Column(name = "DS_GENERO")
    private String dsGenero;

    @Column(name = "NR_TELEFONE1")
    private String nrTelefoneCliente;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA_CLIENTE")
    private CategoriaClienteEntity categoriaClienteEntity;
}
