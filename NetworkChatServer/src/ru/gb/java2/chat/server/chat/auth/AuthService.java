package ru.gb.java2.chat.server.chat.auth;

import java.util.Arrays;
import java.util.List;

public class AuthService {

    private static List<User> USERS = Arrays.asList(
            new User("login1", "pass1", "username1"),
            new User("login2", "pass2", "username2"),
            new User("login3", "pass3", "username3")
    );


    public String getUsernameByLoginAndPassword(String login, String password) {
        User requiredUser = new User(login, password);
        for (User user : USERS) {
            if (requiredUser.equals(user)) {
                return user.getUsername();
            }
        }

        return null;
    }
}
