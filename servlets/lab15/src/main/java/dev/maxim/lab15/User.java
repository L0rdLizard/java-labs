package dev.maxim.lab15;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;  // хранить пароли в plaintext это круто!

    public User(String name) {
        this.username = name;
        this.password = name;  // безопасность!
    }
}
