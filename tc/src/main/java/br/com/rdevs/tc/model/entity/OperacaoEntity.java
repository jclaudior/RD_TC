package br.com.rdevs.tc.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_OPERACAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacaoEntity implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_OPERACAO")
    private Long cdOperacao;

/*    @ManyToOne
    @JoinColumn(name = "ID_TIPO_OPERACAO")
    //@Column(name = "ID_TIPO_OPERACAO")
    private TipoOperacaoEntity tipoOperacao;*/

    @Column(name = "DS_OPERACAO")
    private String descricaoOperacao;

}
