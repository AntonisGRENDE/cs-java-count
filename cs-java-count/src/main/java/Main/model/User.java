package Main.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String email, phone, source;

    public User(String email, String phone, String source) {
        this.email = email;
        this.phone = phone;
        this.source = source;
    }
    @Override
    public String toString() {
        return  "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", source='" + source + '\'';
    }
}
