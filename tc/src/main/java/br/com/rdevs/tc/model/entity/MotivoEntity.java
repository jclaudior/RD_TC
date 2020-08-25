package br.com.rdevs.tc.model.entity;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Enabled
@Table(name = "TB_MOTIVO")
@Data
public class MotivoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOTIVO")
    private BigInteger idMotivo;

    @Column(name = "DS_MOTIVO")
    private String dsMotivo;
}
