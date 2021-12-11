package com.skills.loan.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.skills.loan.dtos.LoanRequestDTO;
import com.skills.loan.dtos.ResponseDTO;
import com.skills.loan.entities.ProfilesEntity;
import com.skills.loan.services.LoanService;
import com.skills.loan.services.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 11:55
 */
@Slf4j
@RestController
@RequestMapping("/v1/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping("/offer/{msisdn}")
    public ResponseDTO fetchLoanOffers(@PathVariable String msisdn) throws JsonProcessingException {
        log.info("Inside Fetch Loan Offers. Msisdn:{}", msisdn);
        return loanService.fetchLoanOffers(msisdn);
    }

    @PostMapping("/request")
    public ResponseDTO requestLoan(@RequestBody LoanRequestDTO loanRequestDTO) throws JsonProcessingException {
        log.info("Inside Request Loan");
        return loanService.requestLoan(loanRequestDTO);
    }
}
