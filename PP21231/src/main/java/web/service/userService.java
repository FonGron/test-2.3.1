package web.service;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public interface userService {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User readUser(long id);
    User deleteUser(long id);

}
