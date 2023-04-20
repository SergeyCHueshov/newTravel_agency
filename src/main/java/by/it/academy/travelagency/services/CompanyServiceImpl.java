package by.it.academy.travelagency.services;

import by.it.academy.travelagency.configs.CompanyProperties;
import by.it.academy.travelagency.dto.CompanyRequest;
import by.it.academy.travelagency.dto.CompanyResponse;
import by.it.academy.travelagency.mapper.CompanyMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper companyMapper;
    private final CompanyProperties companyProperties;

    @Override
    public CompanyResponse getCompany(CompanyRequest companyRequest) {
        String oficialStateRegistrationNumber = companyRequest.getOfficialStateRegistrationNumber();
        if (oficialStateRegistrationNumber.isEmpty()) {
            log.info("There is no such company");
        } else {
            log.info("This company exists");
        }
        return companyMapper.buildCompanyResponse(companyProperties);
    }
}