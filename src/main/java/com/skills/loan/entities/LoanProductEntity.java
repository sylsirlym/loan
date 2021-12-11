package com.skills.loan.entities;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 14:35
 */
@Data
@Entity
@Table(name="loanproducts")
@Where(clause = "active='1'")
public class LoanProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanproductid")
    private int loanProductID;
    @Column(name = "loanproductname")
    private String loanProductName;
    @Column(name = "maxallowablelimit")
    private double maxAllowableLimit;
    private int interest;
    private int active;

    @OneToOne()
    @JoinColumn(name = "tenureid")
    private TenureEntity tenureEntity;
}
