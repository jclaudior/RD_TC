package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaClienteDTO {

    private Integer idCategoriaCliente;
    private String dsCategoriaCliente;
    private float pcDescontoCliente;
}
