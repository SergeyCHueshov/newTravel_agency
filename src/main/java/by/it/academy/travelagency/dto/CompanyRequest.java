package by.it.academy.travelagency.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyRequest {
    @NotBlank
    private String companyName;
    @NotBlank
    private String officialStateRegistrationNumber;
}
