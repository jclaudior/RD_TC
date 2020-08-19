package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ProdutoDTO;
import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.repository.ProdutoRepository;
import br.com.rdevs.tc.service.bo.ProdutoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoBo produtoBo;
    @Autowired
    private ProdutoRepository produtoRep;
    public List<ProdutoDTO> listarProduto(){
        List<ProdutoEntity> listaEntity = produtoRep.findAll();
        List<ProdutoDTO> listaDto = new ArrayList<>();
        for (ProdutoEntity produtoEntity: listaEntity) {
            listaDto.add(produtoBo.ParseToDto(produtoEntity));

        }
        return listaDto;
    }

    public ProdutoDTO listarPorId(BigInteger cdProduto){
        ProdutoEntity produtoEntity = produtoRep.getOne(cdProduto);
        ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO = (produtoBo.ParseToDto(produtoEntity));


        return produtoDTO;
    }
<<<<<<< HEAD

    public List<ProdutoDTO> listarPorNome(String nomeProduto){
        List<ProdutoEntity> listaEntity = produtoRep.findByNmFantasiaContaining(nomeProduto);
        List<ProdutoDTO> listaDto = new ArrayList<>();
        for (ProdutoEntity produtoEntity: listaEntity) {
            listaDto.add(produtoBo.ParseToDto(produtoEntity));

        }
        return listaDto;
    }
=======
>>>>>>> APIRESERVA3
}