package br.com.rdevs.tc.controller;

import br.com.rdevs.tc.model.dto.DocumentoFiscalDTO;
import br.com.rdevs.tc.model.dto.ReservaDTO;
import br.com.rdevs.tc.repository.DocumentoFiscalRepository;
import br.com.rdevs.tc.service.DocumentoFiscalService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/nf")
public class DocumentoFiscalController {

    @Autowired
    DocumentoFiscalService service;

    @GetMapping("/{codigoCupomFiscal}")
    public ResponseEntity buscarPorId(@PathVariable("codigoCupomFiscal") BigInteger idDocumentoFiscal){
        return service.buscarPorId(idDocumentoFiscal);
    }

    @PostMapping("/devolucao")
    public ResponseEntity inserir(@RequestBody DocumentoFiscalDTO dto){
        return service.inserir(dto);
        //return ResponseEntity.ok().body(dto);
    }

}
