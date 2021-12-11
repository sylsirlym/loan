package com.skills.loan.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skills.loan.dtos.LoanDTO;
import com.skills.loan.dtos.LoanOffer;
import com.skills.loan.dtos.LoanRequestDTO;
import com.skills.loan.dtos.ResponseDTO;
import com.skills.loan.entities.LoanEntity;
import com.skills.loan.entities.LoanOfferEntity;
import com.skills.loan.utilities.ResponseManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 14:22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoanService {
    private final StorageService storageService;
    private final ResponseManager responseManager;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    /**
     * Fetches available loans
     * @param msisdn
     * @return
     * @throws JsonProcessingException
     */
    public ResponseDTO fetchLoanOffers(String msisdn) throws JsonProcessingException {
        log.info("About to fetch loan offers for:{}",msisdn);
        var profile = storageService.fetchProfiles(msisdn);
        var loanOffers = storageService.fetchLoanOfferByProfile(profile.getProfileID());
        log.info("Fetched {} loan offers for:{}",loanOffers.size(),msisdn);
        log.info("Loan Offers:{}",objectMapper.writeValueAsString(loanOffers));
        List<LoanOffer> loanOfferList = loanOffers
                .stream()
                .map(offerEntity -> modelMapper.map(offerEntity, LoanOffer.class))
                .collect(Collectors.toList());

        return responseManager.successResponse(loanOfferList);
    }

    /**
     * Handles request loan functionality
     *
     * @param loanRequestDTO
     * @return
     * @throws JsonProcessingException
     */
    public ResponseDTO requestLoan(LoanRequestDTO loanRequestDTO) throws JsonProcessingException {
        log.info("Request Loan Payload:{}",objectMapper.writeValueAsString(loanRequestDTO));
        var loanOffer = storageService.fetchLoanOfferByID(loanRequestDTO.getLoanOfferID());
        log.info("About to apply for Loan:{}",objectMapper.writeValueAsString(loanOffer));
        var requestedPrinciple = loanRequestDTO.getPrinciple();
        if(this.isAmountEligible(loanOffer.getAmount(), requestedPrinciple)){
            log.info("Amount is eligible. Proceed to record loan and fund the account");
            var loanEntity = this.createLoanEntity(loanRequestDTO, loanOffer);
            loanEntity = storageService.saveLoan(loanEntity);

            if (this.fundAccount(requestedPrinciple)){
                loanEntity.setLoanStatus("Disbursed");
                loanEntity = storageService.saveLoan(loanEntity);
                var loan = modelMapper.map(loanEntity, LoanDTO.class);
                return responseManager.successResponse(loan);
            }
            return responseManager.failedResponse("Could not fund account",null);
        }
        return responseManager.failedResponse("Requested amount "+requestedPrinciple+" is greater than allowed principle "+loanOffer.getAmount(),null);
    }

    /**
     * Creates a loan entity
     * @param loanRequestDTO
     * @param loanOffer
     * @return
     * @throws JsonProcessingException
     */
    private LoanEntity createLoanEntity(LoanRequestDTO loanRequestDTO, LoanOfferEntity loanOffer) throws JsonProcessingException {
        var loanEntity = modelMapper.map(loanRequestDTO, LoanEntity.class);
        loanEntity.setLoanOfferEntity(loanOffer);
        loanEntity.setLoanDate(new Date());
        loanEntity.setLoanPrincipal(loanRequestDTO.getPrinciple());
        loanEntity.setLoanStatus("Received");
        loanEntity.setActive(1);
        log.info("Loan Entity:{}", objectMapper.writeValueAsString(loanEntity));
        return loanEntity;
    }

    /**
     * Simulates fund account functionality
     * If the amount is 5000, the funding fails
     * Otherwise, it is successful
     * @param amount
     * @return
     */
    private boolean fundAccount(double amount){
        return amount!=5000;
    }

    /**
     * Check if requested amount is elligible
     * Returns true if requested amount is equal or less than the allowed amount
     *
     * @param allowedAmount - Max Amount the customer is allowed to borrow
     * @param requestedPrinciple - Customer principle
     * @return
     */
    private boolean isAmountEligible(double allowedAmount, double requestedPrinciple){
        return allowedAmount>=requestedPrinciple;
    }
}
