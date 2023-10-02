package by.it.academy.travelagency.dto;

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
public class UpdateUserRequest {
    @NotNull
    private UUID id;
    private String firstname;
    private String secondname;
    private Integer age;
    private String login;
    private String password;
}
