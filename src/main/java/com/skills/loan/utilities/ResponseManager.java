package com.skills.loan.utilities;

import com.skills.loan.configs.LoanConfigurations;
import com.skills.loan.dtos.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by musyokisyl81@gmail.com
 * Project loan
 * User: sylvester.musyoki
 * Date: 11/12/2021
 * Time: 15:22
 */
@Component
@RequiredArgsConstructor
public class ResponseManager {
    private final LoanConfigurations loanConfigurations;
    public ResponseDTO successResponse(Object result){
        var response = new ResponseDTO();
        response.setStatusCode(loanConfigurations.getSuccessStatusCode());
        response.setStatusMessage(loanConfigurations.getSuccessStatusMessage());
        response.setResult(result);
        return response;
    }

    public ResponseDTO failedResponse(String statusMessage,Object result){
        var response = new ResponseDTO();
        response.setStatusCode(loanConfigurations.getFailedStatusCode());
        response.setStatusMessage(statusMessage);
        response.setResult(result);
        return response;
    }
}
