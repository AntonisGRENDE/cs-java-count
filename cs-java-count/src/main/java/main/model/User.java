package main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String email, phone, source;

    @Override
    public String toString() {
        return  "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", source='" + source + '\'';
    }
}
