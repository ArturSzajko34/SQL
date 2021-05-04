package Task4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.OffsetDateTime;
import java.util.List;


public class runDB {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gym_db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        GymEntity gymEntity = prepareEntity("Zielonka", "U Jara");
//        EmployeeEntity employeeEntity = prepareEmployee("Sabina", "Trener");
//
//        List<EmployeeEntity> employeeEntitiesList = new ArrayList<>();
//        employeeEntitiesList.add(employeeEntity);
//
//        gymEntity.setEmployeeEntities(employeeEntitiesList);
//        employeeEntity.setGymEntity(gymEntity);
//
//        saveGym(entityManager, gymEntity, employeeEntity);
//
//        CardTypeEntity cardTypeEntity = prepareCardTypeEntity("Easy",100);
//        saveCard(entityManager,cardTypeEntity);
//
//        ClientEntity clientEntity = prepareClientEntity("Patryk");
//        saveClient(entityManager,clientEntity);


//        List<GymEntity> gymEntityList = entityManager.createQuery("select s from GymEntity s",GymEntity.class)
//                .getResultList();
//        GymEntity gymEntity = gymEntityList.get(1);
//
//        System.out.println(gymEntity);
//
//        List<CardTypeEntity> cardTypeEntityList = entityManager.createQuery("select s from CardTypeEntity s",CardTypeEntity.class)
//                .getResultList();
//
//        System.out.println(cardTypeEntityList);
//        System.out.println(gymEntity);
//
//        gymEntity.getCardTypeEntitySet().add(cardTypeEntityList.get(2));



        List<ClientEntity> clientEntities = entityManager.createQuery("select s from ClientEntity s",ClientEntity.class)
                .getResultList();
        ClientEntity clientEntity = clientEntities.get(0);

        System.out.println(clientEntity);


        List<CardTypeEntity> cardTypeEntities = entityManager.createQuery("select s from CardTypeEntity s",CardTypeEntity.class)
                .getResultList();

        System.out.println(cardTypeEntities);
//
//
//        clientEntity.getCardEntityList().add(cardTypeEntities.get(1));
//

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


    private static CardTypeEntity prepareCardTypeEntity(String name, int Price) {
        CardTypeEntity cardTypeEntity = new CardTypeEntity();
        cardTypeEntity.setName(name);
        cardTypeEntity.setPrice(Price);
        return cardTypeEntity;
    }

    private static void saveCard(EntityManager entityManager, CardTypeEntity cardTypeEntity){
        entityManager.getTransaction().begin();
        entityManager.persist(cardTypeEntity);
        entityManager.getTransaction().commit();
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

    private static ClientEntity prepareClientEntity(String name) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(name);
        return clientEntity;
    }

    private static void saveClient(EntityManager entityManager,ClientEntity clientEntity){
        entityManager.getTransaction().begin();
        entityManager.persist(clientEntity);
        entityManager.getTransaction().commit();
    }
}



