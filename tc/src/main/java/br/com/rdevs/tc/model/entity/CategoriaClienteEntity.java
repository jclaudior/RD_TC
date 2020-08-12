package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CATEGORIA_CLIENTE")
@Data
public class CategoriaClienteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA_CLIENTE")
    private Integer idCategoriaCliente;

    @Column(name = "DS_CATEGORIA_CLIENTE")
    private String dsCategoriaCliente;

    @Column(name = "PC_DESCONTO_CLIENTE")
    private float pcDescontoCliente;
}
