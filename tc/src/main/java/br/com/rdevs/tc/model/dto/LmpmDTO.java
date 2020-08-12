package br.com.rdevs.tc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LmpmDTO {

    private int idLmpm;
    private Date dtInicioLmpm;
    private Date dtFimLmpm;
}
