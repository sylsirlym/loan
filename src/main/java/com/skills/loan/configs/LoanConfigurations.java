package com.skills.loan.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 15:24
 */
@Component
@Data
@ConfigurationProperties("loan.configs")
public class LoanConfigurations {
    private int successStatusCode;
    private String successStatusMessage;
}
