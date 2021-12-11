package com.skills.loan.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 14:23
 */
@Data
@NoArgsConstructor
public class ResponseDTO {
    private int statusCode;
    private String statusMessage;
    private Object result;
}
