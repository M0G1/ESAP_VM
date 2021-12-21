package com.example.esap_vm.dao;

import com.example.esap_vm.model.Drive;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DrivesDao {


    public void create(Drive drive) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(drive);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Drive get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Drive drive = entityManager.find(Drive.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return drive;
    }

    public List<Drive> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
                // !!!!! DRIVE / DRIVES
        List<Drive> drive = entityManager.createQuery("select d from Drive d", Drive.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return drive;
    }

    public void update(Long id, Drive newDriveData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Drive drive = entityManager.find(Drive.class, id);
        if (drive != null) {
            drive.setCost(newDriveData.getCost());
            drive.setHours(newDriveData.getHours());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Drive drive = entityManager.find(Drive.class, id);
        if (drive != null) {
            entityManager.remove(drive);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
