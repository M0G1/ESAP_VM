package com.example.esap_vm.dao;

import com.example.esap_vm.model.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UsersDao {

    public void create(User user) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(user);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public User get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public List<User> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<User> user = entityManager.createQuery("select u from User u", User.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public void update(Long id, User newUserData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, id);
        if (user != null) {
            user.setBudget(newUserData.getBudget());
            user.setName(newUserData.getName());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
