package by.it.academy.travelagency.controllers;


import by.it.academy.travelagency.dto.CompanyRequest;
import by.it.academy.travelagency.dto.CompanyResponse;
import by.it.academy.travelagency.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping({"{companyName}"})
    public CompanyResponse getCompany(@Validated @RequestBody CompanyRequest companyRequest) {
        return companyService.getCompany(companyRequest);
    }
}
