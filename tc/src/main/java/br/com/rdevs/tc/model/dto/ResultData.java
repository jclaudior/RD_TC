package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData<T> {

    private Integer status;

    private String mensagem;

    private T retorno;

    public ResultData(Integer status, String mensagem){
        this.status = status;
        this.mensagem = mensagem;
    }

}
