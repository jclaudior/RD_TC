package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.entity.ProdutoEntity;
import br.com.rdevs.tc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRep;
    public List<ProdutoEntity> listarProduto(){
        return produtoRep.findAll();
    }
}