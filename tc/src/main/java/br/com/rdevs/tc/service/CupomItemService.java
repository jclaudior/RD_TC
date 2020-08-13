package br.com.rdevs.tc.service;

import br.com.rdevs.tc.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CupomItemService {

    @Autowired
    CupomRepository repository;


}
