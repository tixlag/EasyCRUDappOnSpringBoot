package ru.tixlag.easycrudapponspringboot.dao;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tixlag.easycrudapponspringboot.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager manager;


    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public User get(int id) {
//        return manager.getObject() .createQuery("from User", User.class).getSingleResult();
        manager.createQuery("from User");
        return null;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) manager.createQuery("from User").getResultList();
    }

    @Override
    public void edit(Long id, User user) {

    }

    @Override
    public void edit(Long id, String name, String lastName, byte age) {
        User currentUser = manager.find(User.class, id);
        currentUser.setName(name);
        currentUser.setLastName(lastName);
        currentUser.setAge(age);
    }

    @Override
    public void delete(Long id) {
        manager.remove(manager.find(User.class, id));
    }
}
