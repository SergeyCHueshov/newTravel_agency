package by.it.academy.travelagency.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UpdateTourRequest {
    @NotNull
    private UUID id;
    private String tourName;
    private String state;
    private String hotel;
    private Integer cost;
    private String additionalInformation;
}

