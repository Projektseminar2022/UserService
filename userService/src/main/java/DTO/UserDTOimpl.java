package DTO;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDTOimpl implements UserDTO {

    @Autowired
    private User user;

    public int getId() {
        return user.getId();
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }
}
