package br.com.rdevs.tc.service;

import br.com.rdevs.tc.model.dto.ResultData;
import br.com.rdevs.tc.model.dto.TcCupomDTO;
import br.com.rdevs.tc.model.entity.TcCupomEntity;
import br.com.rdevs.tc.repository.CupomRepository;
import br.com.rdevs.tc.service.bo.CupomBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class CupomService {

    @Autowired
    CupomRepository repository;

    @Autowired
    CupomBO bo;

    @Autowired
    private JavaMailSender mailSender;

    public void enviar() {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("joaoclaudiodiva@gmail.com");
        email.setSubject("Teste envio de e-mail");
        email.setText("Enviei este e-mail usando Spring Boot.");
        mailSender.send(email);
    }

    public ResponseEntity buscarCupom(BigInteger idCliente){
        ResultData resultData = null;
        if(Integer.parseInt(idCliente.toString()) <= 0){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro id cliente invalido! ");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }
        try {
            TcCupomEntity entity = new TcCupomEntity();
            TcCupomDTO dto = new TcCupomDTO();
            Date date = new Date();
            entity = repository.findByClienteIdClienteAndDtFinalCupomGreaterThanEqual(idCliente, date);
            dto = bo.parseToDTO(entity);
        resultData = new ResultData(HttpStatus.ACCEPTED.value(), "Consulta de cupom realizada com sucesso!", dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(resultData);
    }catch (Exception e){
        resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "Erro ao consultar cupom " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
    }
    }

}
