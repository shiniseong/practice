package org.example;

import org.example.windows.dto.request.UserRequestDto;

public class Main {
    public static void main(String[] args) {
        UserRequestDto userRequestDto1 = new UserRequestDto("name1", "email1", "password1");
        UserRequestDto userRequestDto2 = new UserRequestDto("name2", "email2", "password2");

        UserRequestDto userRequestDto1updated = new UserRequestDto("name1updated", "email1", "password1");

        System.out.println(Dependencies.userController.createUser(userRequestDto1));
        System.out.println(Dependencies.userController.createUser(userRequestDto2));
        System.out.println(Dependencies.userController.getUsers());
        System.out.println(Dependencies.userController.getUser("email1"));
        System.out.println(Dependencies.userController.updateUser(userRequestDto1updated));
        System.out.println(Dependencies.userController.getUser("email1"));
        System.out.println(Dependencies.userController.deleteUser("email1"));
        System.out.println(Dependencies.userController.getUsers());
        System.out.println(Dependencies.userController.getUser("email1"));
    }
}
