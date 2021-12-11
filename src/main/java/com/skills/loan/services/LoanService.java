package com.skills.loan.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skills.loan.dtos.LoanOffer;
import com.skills.loan.dtos.ResponseDTO;
import com.skills.loan.utilities.ResponseManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public ResponseDTO fetchLoanOffers(String msisdn) throws JsonProcessingException {
        log.info("About to fetch loan offers for:{}",msisdn);
        var profile = storageService.fetchProfiles(msisdn);
        var loanOffers = storageService.fetchLoanOfferByProfile(profile.getProfileID());
        log.info("Fetched {} loan offers for:{}",loanOffers.size(),msisdn);
        log.info("Loan Offers:{}",objectMapper.writeValueAsString(loanOffers));
        List<LoanOffer> loanOfferList = loanOffers
                .stream()
                .map(offerEntity -> modelMapper.map(offerEntity, LoanOffer.class))
//                .peek(loanOffer -> loanOffer.setInterest())
                .collect(Collectors.toList());

        return responseManager.successResponse(loanOfferList);
    }

}
