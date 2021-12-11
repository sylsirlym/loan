package com.skills.loan.entities;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 14:28
 */
@Data
@Entity
@Table(name="loanoffer")
@Where(clause = "active='1'")
public class LoanOfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanofferid")
    private int loanOfferID;
    @Column(name = "profileid")
    private int profileID;
    private double amount;
    private int active;

    @OneToOne()
    @JoinColumn(name = "loanproductid")
    private LoanProductEntity loanProductEntity;
}
