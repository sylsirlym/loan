package com.skills.loan.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 17:31
 */
@Data
public class LoanDTO {
    private String loanName;
    private double principal;
    private String loanStatus;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date loanDate;
}
