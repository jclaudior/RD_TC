package br.com.rdevs.tc.service.bo;

import br.com.rdevs.tc.model.dto.MelhorPrecoDTO;
import br.com.rdevs.tc.model.dto.OperadorDTO;
import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.entity.MelhorPrecoEntity;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Component
public class MelhorPercoBO {

    @Autowired
    ProdutoBo BOProduto;

    @Autowired
    ClienteBO BOCliente;

    @Autowired
    LoginBO BOOperador;

    public MelhorPrecoEntity parseToEntity (MelhorPrecoDTO dto, MelhorPrecoEntity entity){
        if(entity == null){
            entity = new MelhorPrecoEntity();
        }
        if(dto == null){
            return entity;
        }

        entity.setIdMelhorPreco(dto.getIdMelhorPreco());
        entity.setQtItem(dto.getQtItem());

        entity.setProdutoEntity(BOProduto.ParseEntity(dto.getProduto()));

        entity.setProdutoEntity(BOProduto.ParseEntity(dto.getProduto()));

        entity.setClienteEntity(BOCliente.parseEntity(dto.getCliente()));
        entity.setOperadorEntity(BOOperador.parseToEntity(dto.getOperador(), null));
        entity.setPcDesconto(dto.getPcDesconto());
        entity.setVlDesconto(dto.getVlDesconto());

        return entity;
    }
}
