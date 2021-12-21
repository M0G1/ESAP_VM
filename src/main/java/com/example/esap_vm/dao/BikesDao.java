package  com.example.esap_vm.dao;

import com.example.esap_vm.model.Bike;
import jakarta.persistence.EntityManager;

import java.util.List;

public class BikesDao {

    public void create(Bike bike) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(bike);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Bike get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Bike bike = entityManager.find(Bike.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return bike;
    }

    public List<Bike> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Bike> bikes = entityManager.createQuery("select b from Bike b", Bike.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return bikes;
    }

    public void update(Long id, Bike newBikeData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Bike bike = entityManager.find(Bike.class, id);
        if (bike != null) {
            bike.setBikeName(newBikeData.getBikeName());
            bike.setPrice(newBikeData.getPrice());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Bike bike = entityManager.find(Bike.class, id);
        if (bike != null) {
            entityManager.remove(bike);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
