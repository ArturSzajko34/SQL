package baza;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Maine {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carRent");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.close();
        entityManagerFactory.close();
    }


    private static void saveCar(EntityManager entityManager, CarEntity carEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(carEntity);
        entityManager.getTransaction().commit();
    }

    private static CarEntity prepareCarEntity() {
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand("audi");
        carEntity.setModel("a3");
        carEntity.setHorsepower(150);
        carEntity.setPrice(15000.00);
        carEntity.setProductionYear(2009);
        return carEntity;
    }
}

