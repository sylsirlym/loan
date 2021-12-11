package com.skills.loan;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.skills.loan.dtos.LoanOffer;
import com.skills.loan.entities.LoanOfferEntity;
import com.skills.loan.entities.LoanProductEntity;
import com.skills.loan.entities.TenureEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);


        var loanOfferEntityLoanOfferTypeMap = modelMapper.createTypeMap(LoanOfferEntity.class, LoanOffer.class);
        loanOfferEntityLoanOfferTypeMap.addMappings(
                new PropertyMap<LoanOfferEntity, LoanOffer>() {
                    @Override
                    protected void configure() {
                        // define a converters that takes the whole Loan Offer Entity
                        using(ctx -> generateTenure(
                                String.valueOf(((LoanOfferEntity) ctx.getSource()).getLoanProductEntity().getTenureEntity().getTenureDuration()),
                                ((LoanOfferEntity) ctx.getSource()).getLoanProductEntity().getTenureEntity().getDurationType())
                        ).map(source, destination.getTenure());

                        using(ctx -> generateInterest(
                                String.valueOf(((LoanOfferEntity) ctx.getSource()).getLoanProductEntity().getInterest()))
                        ).map(source, destination.getInterest());
                    }
                });

        return modelMapper;
    }

    private String generateTenure(String type, String duration) {
        return type + " " + duration;
    }

    private String generateInterest(String interest) {
        return interest+" %";
    }

    @Bean
    public ObjectMapper objectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return objectMapper;
    }
}
