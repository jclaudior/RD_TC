package br.com.rdevs.tc.model.entity;

<<<<<<< HEAD
import lombok.Data;

import javax.persistence.*;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
>>>>>>> APIRESERVA3
import java.math.BigInteger;

@Entity
@Table(name = "TB_TC_RESERVA_ITEM")
@Data
<<<<<<< HEAD
public class ReservaItemEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TC_RESERVA_ITEM")
    private BigInteger idTcReservaItem;


    @ManyToOne
    @JoinColumn(name = "ID_RESERVA")
    private ReservaEntity reserva;

=======
public class ReservaItemEntity implements Serializable {

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TC_RESERVA")
    private ReservaEntity reserva;

    @Id
>>>>>>> APIRESERVA3
    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;

    @Column(name = "QT_PRODUTO")
    private Integer qtProduto;

<<<<<<< HEAD





=======
>>>>>>> APIRESERVA3
}
