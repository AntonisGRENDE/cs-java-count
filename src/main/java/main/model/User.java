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

    @Override
    public boolean equals(Object obj) {
        try {
            User user = (User) obj;
            return this.email.equals(user.email) && (this.phone.equals(user.phone));
        } catch (ClassCastException ex){
            return false;
        }
    }
}
