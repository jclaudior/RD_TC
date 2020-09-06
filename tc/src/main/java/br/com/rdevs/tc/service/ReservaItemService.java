package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.model.entity.ReservaItemPK;
import br.com.rdevs.tc.repository.ReservaItemRepository;
import br.com.rdevs.tc.service.bo.ProdutoBo;
import br.com.rdevs.tc.service.bo.ReservaBO;
import br.com.rdevs.tc.service.bo.ReservaItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private  AlterarEstoqueService alterarEstoqueService;

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

    public ResponseEntity alterar(ReservaItemDTO dto) {
        ResultData resultData = null;

        if (dto.getReserva() == null) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Dados da reserva inválidos! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

        if (dto.getProduto() == null) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Dados do produto inválidos! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

        if (dto.getQtProduto() <= 0 || dto.getQtProduto() == null) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Quantidade de produto inválido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

        try {


            ReservaItemPK pk = new ReservaItemPK();
            ReservaEntity reservaEntity = new ReservaEntity();
            reservaEntity.setIdTcReserva(dto.getReserva().getIdTcReserva());
            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setCdProduto(dto.getProduto().getCdProduto());

            pk.setReserva(reservaEntity);
            pk.setProduto(produtoEntity);

            Integer qtAnterior = repository.getOne(pk).getQtProduto();

            pk.setReserva(reservaBO.parseToEntity(dto.getReserva(), null));
            pk.setProduto(produtoBo.ParseEntity(dto.getProduto()));

            ReservaItemEntity entity = repository.getOne(pk);

            entity.setQtProduto(dto.getQtProduto());



            repository.save(entity);
            alterarEstoqueService.alterarItemReserva(entity, qtAnterior);

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Alteração realizada com sucesso!", dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);

        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Erro ao alterar o item da reserva! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

    }

    public ResponseEntity deletar(BigInteger idTcReserva, BigInteger cdProduto) {
        ResultData resultData = null;

        if (idTcReserva == null) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Dados da reserva inválidos! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

        if (cdProduto == null) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Dados do produto inválidos! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }

        try {
            ReservaItemPK pk = new ReservaItemPK();

            ReservaEntity reservaEntity = new ReservaEntity();
            reservaEntity.setIdTcReserva(idTcReserva);

            pk.setReserva(reservaEntity);


            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setCdProduto(cdProduto);

            pk.setProduto(produtoEntity);

            ReservaItemEntity entity = repository.getOne(pk);

            repository.delete(entity);
            alterarEstoqueService.removerItemReserva(entity);

            resultData = new ResultData(HttpStatus.ACCEPTED.value(),"Item excluído com sucesso!");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);

        } catch (Exception e) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro ao excluir o item da reserva! " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
    }
}
