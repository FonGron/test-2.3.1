package web.dao;
import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class userDaoImpl implements userDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User deleteUser(long id) throws NullPointerException {
        User user = readUser(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }
}
