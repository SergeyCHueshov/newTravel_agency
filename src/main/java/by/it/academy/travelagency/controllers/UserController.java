package by.it.academy.travelagency.controllers;

import by.it.academy.travelagency.dto.UpdateTourRequest;
import by.it.academy.travelagency.dto.UpdateUserRequest;
import by.it.academy.travelagency.dto.UserRequest;
import by.it.academy.travelagency.dto.UserResponse;
import by.it.academy.travelagency.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userServiceImpl;

    @GetMapping("{id}")
    public UserResponse getUser(@PathVariable UUID id) {
        return userServiceImpl.getUser(id);
    }
    @GetMapping
    public List<UserResponse> getAllUsers(@PageableDefault() Pageable pageable) {
        return userServiceImpl.getAllUsers(pageable);
    }
    @GetMapping("{firstname}/{secondname}")
    public List<UserResponse> getUserByFirstnameAndSecondName(@PathVariable String firstname, @PathVariable String secondname) {
        return userServiceImpl.getByFirstnameAndSecondName(firstname, secondname);
    }
    @GetMapping("{firstname}/{age}")
    public List<UserResponse> getUserByFirstnameAndAge(@PathVariable String firstname, @PathVariable Integer age) {
        return userServiceImpl.getByFirstnamenameAndAge(firstname, age);
    }
    @GetMapping("{secondname}/{age}")
    public List<UserResponse> getUserBySecondnameAndAge(@PathVariable String secondname, @PathVariable Integer age) {
        return userServiceImpl.getBySecondnameAndAge(secondname, age);
    }
    @PostMapping
    public UserResponse createUser(@Validated @RequestBody UserRequest userRequest) {
        return userServiceImpl.createUser(userRequest);
    }

    @PutMapping
    public UserResponse updateUser(@Validated @RequestBody UpdateUserRequest updateUserRequest) {
        return userServiceImpl.updateUser(updateUserRequest);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable UUID id) {
        userServiceImpl.deleteUser(id);
    }
}
