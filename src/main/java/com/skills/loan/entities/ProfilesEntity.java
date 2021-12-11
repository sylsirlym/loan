package com.skills.loan.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 11:18
 */
@Data
@Entity
@Table(name="profiles")
@Where(clause = "active='1'")
public class ProfilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileID;
    private String msisdn;
    private String pinHash;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @UpdateTimestamp
    private Timestamp dateModified;
    private int active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customers customers;
}
