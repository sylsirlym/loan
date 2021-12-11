package com.skills.loan.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 17:01
 */

@Data
@Entity
@DynamicUpdate
@Table(name="loan")
@Where(clause = "active='1'")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanid")
    private int loanID;
    @Column(name = "loanprincipal")
    private double loanPrincipal;
    @Column(name = "loanstatus")
    private String loanStatus;
    @Column(name = "loandate")
    private Date loanDate;
    private int active;

    @OneToOne()
    @JoinColumn(name = "loanofferid")
    private LoanOfferEntity loanOfferEntity;
}
