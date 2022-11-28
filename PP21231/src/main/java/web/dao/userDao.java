package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import web.model.User;

import java.util.List;

@Component
public interface userDao {
    List<User> getAllUsers();
    void createUser(User user);
    void updateUser(User user);
    User readUser(long id);
    User deleteUser(long id);
}
