package org.example.windows.controller;


import org.example.domain.usecase.UserManagement;
import org.example.windows.dto.request.UserRequestDto;
import org.example.windows.dto.response.ApiCommonResponse;
import org.example.windows.dto.response.UserResponseDto;

import java.util.List;

public class UserController {
    private final UserManagement userService;

    public UserController(UserManagement userService) {
        this.userService = userService;
    }

    public ApiCommonResponse<UserResponseDto> createUser(UserRequestDto user) {
        try {
            return ApiCommonResponse.success(UserResponseDto.of(userService.createUser(user.toDomain())));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ApiCommonResponse.fail(e.getMessage());
        }
    }

    public ApiCommonResponse<UserResponseDto> getUser(String email) {
        try {
            return ApiCommonResponse.success(UserResponseDto.of(userService.getUser(email)));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ApiCommonResponse.fail(e.getMessage());
        }
    }

    public ApiCommonResponse<UserResponseDto> updateUser(UserRequestDto user) {
        try {
            return ApiCommonResponse.success(UserResponseDto.of(userService.updateUser(user.toDomain())));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ApiCommonResponse.fail(e.getMessage());
        }
    }


    public ApiCommonResponse<Void> deleteUser(String email) {
        try {
            userService.deleteUser(email);
            return ApiCommonResponse.success(null);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ApiCommonResponse.fail(e.getMessage());
        }
    }

    public ApiCommonResponse<List<UserResponseDto>> getUsers() {
        try {
            return ApiCommonResponse.success(userService.getUsers().stream().map(UserResponseDto::of).toList());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ApiCommonResponse.fail(e.getMessage());
        }
    }
}
