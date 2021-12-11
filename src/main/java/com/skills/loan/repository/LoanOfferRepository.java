package com.skills.loan.repository;

import com.skills.loan.entities.LoanOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 14:43
 */
public interface LoanOfferRepository extends JpaRepository<LoanOfferEntity, Integer> {
    List<LoanOfferEntity> findAllByProfileID(int profileID);
    LoanOfferEntity findLoanOfferEntityByLoanOfferID(int loanOfferID);
}
