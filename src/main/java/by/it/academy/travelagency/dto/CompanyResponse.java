package by.it.academy.travelagency.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyResponse {
    private String companyName;
    private String officialStateRegistrationNumber;
}
