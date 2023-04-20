package by.it.academy.travelagency.services;

import by.it.academy.travelagency.dto.UpdateUserRequest;
import by.it.academy.travelagency.dto.UserRequest;
import by.it.academy.travelagency.dto.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse getUser(UUID id);

    List<UserResponse> getByFirstnameAndSecondName(String firstname, String secondname);

    List<UserResponse> getByFirstnamenameAndAge(String firstname, int age);

    List<UserResponse> getBySecondnameAndAge(String secondname, int age);

    UserResponse createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers(Pageable pageable);

    UserResponse updateUser(UpdateUserRequest updateUserRequest);

    void deleteUser(UUID id) throws RuntimeException;
}
