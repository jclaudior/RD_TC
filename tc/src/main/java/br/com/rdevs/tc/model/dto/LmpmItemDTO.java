package br.com.rdevs.tc.model.dto;

import br.com.rdevs.tc.model.entity.LmpmEntitty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LmpmItemDTO {

    private int idLmpmItem;
    private int qtProduto;
    private float pcDesconto;
    private LmpmDTO lmpm;
}
