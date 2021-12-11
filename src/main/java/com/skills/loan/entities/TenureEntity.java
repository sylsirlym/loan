package com.skills.loan.entities;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 14:40
 */
@Data
@Entity
@Table(name="tenures")
@Where(clause = "active='1'")
public class TenureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenureid")
    private int tenureID;
    @Column(name = "tenureduration")
    private int tenureDuration;
    @Column(name = "durationtype")
    private String durationType;
    private int active;
}
