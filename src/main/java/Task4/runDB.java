package Task4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


public class runDB {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gym_db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        GymEntity gymEntity = prepareEntity("Zielonka", "U Jara");
        EmployeeEntity employeeEntity = prepareEmployee("Sabina", "Trener");

        List<EmployeeEntity> employeeEntitiesList = new ArrayList<>();
        employeeEntitiesList.add(employeeEntity);

        gymEntity.setEmployeeEntities(employeeEntitiesList);
        employeeEntity.setGymEntity(gymEntity);

        saveGym(entityManager, gymEntity, employeeEntity);

        entityManager.close();
        entityManagerFactory.close();

    }

    private static GymEntity prepareEntity(String city, String name) {
        GymEntity gymEntity = new GymEntity();
        gymEntity.setName(name);
        gymEntity.setCity(city);
        gymEntity.setOpenFrom(OffsetDateTime.now());
        gymEntity.setOpenTo(OffsetDateTime.now());
        return gymEntity;
    }


    private static EmployeeEntity prepareEmployee(String name, String type) {
        return new EmployeeEntity(name, type);
    }


    private static void saveGym(EntityManager entityManager, GymEntity gymEntity, EmployeeEntity employeeEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(gymEntity);
        entityManager.persist(employeeEntity);
        entityManager.getTransaction().commit();
    }


}



