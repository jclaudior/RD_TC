package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.repository.ClienteRepository;
import br.com.rdevs.tc.repository.ReservaRepository;
import br.com.rdevs.tc.service.bo.ClienteBO;
import br.com.rdevs.tc.service.bo.ReservaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private ClienteBO clienteBO;

    @Autowired
    private ReservaBO reservaBo;

    public List<ReservaDTO> listarPorCliente(BigInteger idCliente) {

        List<ReservaEntity> listEntity = repository.findByClienteIdCliente(idCliente);
        List<ReservaDTO> listDTO = new ArrayList<>();
        for (ReservaEntity entity : listEntity) {
            ReservaDTO dto = new ReservaDTO();
            dto.setClienteDTO(clienteBO.parseDTO(entity.getCliente()));
            dto.setDtInicialReserva(entity.getDtFinalReserva());
            dto.setDtFinalReserva(entity.getDtFinalReserva());

            List<ReservaItemDTO> listaItemDTO = new ArrayList<>();
            for (ReservaItemEntity item : entity.getItens()) {
                ReservaItemDTO itemDTO = new ReservaItemDTO();
                ProdutoDTO produtoDTO = new ProdutoDTO();
                produtoDTO.setCdProduto(item.getProduto().getCdProduto());
                produtoDTO.setIdCategoria(item.getProduto().getIdCategoria());
                produtoDTO.setIdStatusProduto(item.getProduto().getIdStatusProduto());
                produtoDTO.setIdTipoProduto(item.getProduto().getIdTipoProduto());
                produtoDTO.setNmFabricante(item.getProduto().getNmFabricante());
                produtoDTO.setNmFantasia(item.getProduto().getNmFantasia());
                produtoDTO.setVlUnidade(item.getProduto().getVlUnidade());

                itemDTO.setProduto(produtoDTO);
                itemDTO.setQtProduto(item.getQtProduto());
                listaItemDTO.add(itemDTO);

            }
            dto.setItens(listaItemDTO);
            listDTO.add(dto);
        }
        return listDTO;

    }
    public void inserir(ReservaDTO dto) {
        ReservaEntity entity = reservaBo.parseToEntity(dto, null);
        if(entity.getCliente() != null)
            repository.save(entity);
    }

}

