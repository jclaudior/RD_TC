package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.model.entity.ReservaItemPK;
import br.com.rdevs.tc.repository.ReservaItemRepository;
import br.com.rdevs.tc.service.bo.ProdutoBo;
import br.com.rdevs.tc.service.bo.ReservaBO;
import br.com.rdevs.tc.service.bo.ReservaItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ReservaItemService {

    @Autowired
    private ReservaItemRepository repository;

    @Autowired
    private ReservaBO reservaBO;

    @Autowired
    private ReservaItemBO reservaItemBO;

    @Autowired
    private ProdutoBo produtoBo;

    public ReservaItemDTO buscarItem(BigInteger idTcReserva, BigInteger cdProduto) {
        ReservaItemPK pk = new ReservaItemPK();

        ReservaEntity reservaEntity = new ReservaEntity();
        reservaEntity.setIdTcReserva(idTcReserva);

        pk.setReserva(reservaEntity);

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setCdProduto(cdProduto);

        pk.setProduto(produtoEntity);

        ReservaItemEntity entity = repository.getOne(pk);
        ReservaItemDTO reservaItemDTO = reservaItemBO.parseToDTO(entity);

        return reservaItemDTO;
    }

    public ReservaItemDTO alterar(ReservaItemDTO dto) {
        ReservaItemPK pk = new ReservaItemPK();
        pk.setReserva(reservaBO.parseToEntity(dto.getReserva(), null));
        pk.setProduto(produtoBo.ParseEntity(dto.getProduto()));

        ReservaItemEntity entity = repository.getOne(pk);

        entity.setQtProduto(dto.getQtProduto());

        repository.save(entity);

        return dto;
    }
}
