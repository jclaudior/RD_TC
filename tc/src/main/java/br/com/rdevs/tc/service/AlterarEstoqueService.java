package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.entity.*;
import br.com.rdevs.tc.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class AlterarEstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public void devolucaoParaEstoque (DocumentoFiscalEntity entity) {

        if(entity.getMotivoDevolucao().getIdMotivo() != BigInteger.valueOf(3) || entity.getMotivoDevolucao().getIdMotivo() != BigInteger.valueOf(4)) {
            List<DocumentoItemEntity> listItens = entity.getItens();
            for (DocumentoItemEntity currentItem : listItens) {

                BigInteger cdProduto = currentItem.getProduto().getCdProduto();
                BigInteger cdFilial = entity.getFilial().getCdFilial();

                List<EstoqueEntitty> entityEstoqueList = estoqueRepository.findByFilialCdFilialAndProdutoCdProduto(cdFilial,cdProduto);
                EstoqueEntitty entityEstoque = entityEstoqueList.get(0);
                Integer ajustEstoque = entityEstoque.getQtEstoque() + currentItem.getQtdItem();
                entityEstoque.setQtEstoque(ajustEstoque);

                estoqueRepository.save(entityEstoque);
            }
        }
    }
    public void adicionarReserva (ReservaEntity entity) {

        List<ReservaItemEntity> listItens = entity.getItens();
        for (ReservaItemEntity currentItem : listItens) {

            BigInteger cdProduto = currentItem.getProduto().getCdProduto();

            List<EstoqueEntitty> entityEstoqueList = estoqueRepository.findByProdutoCdProduto(cdProduto);
            EstoqueEntitty entityEstoque = entityEstoqueList.get(0);
            Integer ajustEstoque = entityEstoque.getQtEmpenho() + currentItem.getQtProduto();
            entityEstoque.setQtEmpenho(ajustEstoque);

            estoqueRepository.save(entityEstoque);
        }
    }
    public void removerItemReserva (ReservaItemEntity entity) {

            BigInteger cdProduto = entity.getProduto().getCdProduto();
            List<EstoqueEntitty> entityEstoqueList = estoqueRepository.findByProdutoCdProduto(cdProduto);
            EstoqueEntitty entityEstoque = entityEstoqueList.get(0);
            Integer ajustEstoque = entityEstoque.getQtEmpenho() - entity.getQtProduto();
            entityEstoque.setQtEmpenho(ajustEstoque);
            estoqueRepository.save(entityEstoque);
    }
    public void alterarItemReserva (ReservaItemEntity entity, Integer novoEmpenho) {

        BigInteger cdProduto = entity.getProduto().getCdProduto();
        List<EstoqueEntitty> entityEstoqueList = estoqueRepository.findByProdutoCdProduto(cdProduto);
        EstoqueEntitty entityEstoque = entityEstoqueList.get(0);
        Integer ajustEstoque = entityEstoque.getQtEmpenho() - entity.getQtProduto();
        entityEstoque.setQtEmpenho(ajustEstoque);
        ajustEstoque = entityEstoque.getQtEmpenho() + novoEmpenho;
        entityEstoque.setQtEmpenho(ajustEstoque);
        estoqueRepository.save(entityEstoque);
    }
}
