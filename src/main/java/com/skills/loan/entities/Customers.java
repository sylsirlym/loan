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
 * Time: 11:41
 */
@Data
@Entity
@Table(name="customers")
@Where(clause = "active='1'")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String email;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @UpdateTimestamp
    private Timestamp dateModified;
    private int active;
}
