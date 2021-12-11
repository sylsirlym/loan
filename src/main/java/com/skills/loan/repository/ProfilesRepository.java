package com.skills.loan.repository;

import com.skills.loan.entities.ProfilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 11:46
 */
public interface ProfilesRepository extends JpaRepository<ProfilesEntity, Integer> {
    ProfilesEntity findProfilesEntityByMsisdn(String msisdn);
}
