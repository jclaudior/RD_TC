package br.com.rdevs.tc.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_LMPM")
@Data
public class LmpmEntitty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LMPM")
    private int idLmpm;

    @Column(name = "DT_INICIO_LMPM")
    private Date dtInicioLmpm;

    @Column(name = "DT_FIM_LMPM")
    private Date dtFimLmpm;
}
