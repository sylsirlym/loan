package com.skills.loan.dtos;

import lombok.Data;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 14:07
 */
@Data
public class LoanOffer {
    private int loanOfferID;
    private String loanProductName;
    private String loanAmount;
    private String interest;
    private String tenure;
}
