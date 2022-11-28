package web.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.userDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class userServiceImpl implements userService{

    private final userDao UD;

    public userServiceImpl(@Qualifier("userDaoImpl") userDao UD) {
        this.UD = UD;
    }

    @Override
    public List<User> getAllUsers() {
        return UD.getAllUsers();
    }

    @Override
    public void createUser(User user) {
        UD.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        UD.updateUser(user);
    }

    @Override
    public User readUser(long id) {
        return UD.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = UD.deleteUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }

}
