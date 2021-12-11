package com.skills.loan.repository;

import com.skills.loan.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 17:06
 */
public interface LoanRepository extends JpaRepository<LoanEntity, Integer> {
}
