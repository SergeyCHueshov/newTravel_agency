package by.it.academy.travelagency.services;

import by.it.academy.travelagency.dto.CompanyRequest;
import by.it.academy.travelagency.dto.CompanyResponse;

public interface CompanyService {
    CompanyResponse getCompany(CompanyRequest companyRequest);
}
