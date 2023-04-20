package by.it.academy.travelagency.mapper;

import by.it.academy.travelagency.configs.CompanyProperties;
import by.it.academy.travelagency.dto.CompanyResponse;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyResponse buildCompanyResponse(CompanyProperties companyProperties) {
        return CompanyResponse.builder()
                .companyName((companyProperties.getCompanyName()))
                .officialStateRegistrationNumber(companyProperties.getOfficialStateRegistrationNumber())
                .build();
    }
}
