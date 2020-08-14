package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.model.dto.ReservaItemDTO;
import br.com.rdevs.tc.model.entity.ReservaEntity;
import br.com.rdevs.tc.model.entity.ReservaItemEntity;
import br.com.rdevs.tc.repository.ClienteRepository;
import br.com.rdevs.tc.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ReservaRepository repository;

    public List<ReservaItemDTO> listarTodas() {

        List<ReservaItemDTO> listaDTO = new ArrayList<>();
        List<ReservaItemEntity> listaEntity = repository.findAll();
        for(ReservaItemEntity reserva : listaEntity){
            ReservaItemDTO dto = new ReservaItemDTO();
            dto.setIdTcReservaItem(reserva.getIdTcReservaItem());
            dto.setCdProduto(reserva.getCdProduto());
            dto.setIdReserva(reserva.getIdReserva());
            dto.setQtProduto(reserva.getQtProduto());

            List<ReservaItemDTO> itens = new ArrayList<>();

        }


}

}
