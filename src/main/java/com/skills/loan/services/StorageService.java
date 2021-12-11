package com.skills.loan.services;

import com.skills.loan.entities.LoanOfferEntity;
import com.skills.loan.entities.ProfilesEntity;
import com.skills.loan.repository.LoanOfferRepository;
import com.skills.loan.repository.ProfilesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 11:50
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StorageService {
    private final ProfilesRepository profilesRepository;
    private final LoanOfferRepository loanOfferRepository;
    public ProfilesEntity fetchProfiles(String msisdn){
        return profilesRepository.findProfilesEntityByMsisdn(msisdn);
    }

    public List<LoanOfferEntity> fetchLoanOfferByProfile(int profileID){
        return loanOfferRepository.findAllByProfileID(profileID);
    }

    public LoanOfferEntity fetchLoanOfferByID(int loanOfferID) {
        return loanOfferRepository.findLoanOfferEntityByLoanOfferID(loanOfferID);
    }
}
