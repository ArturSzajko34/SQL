package Task2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class Maine {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("smartphone_shop_db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<SmartphoneEntity> smartphoneEntities = entityManager.createQuery("select s from SmartphoneEntity s",SmartphoneEntity.class)
                .getResultList();

        List<ClientEntity> clientEntities = entityManager.createQuery("select c from ClientEntity c",ClientEntity.class)
                .getResultList();


        ClientEntity firstClient = clientEntities.get(0);
        ClientEntity secondClient = clientEntities.get(1);
        SmartphoneEntity firstSmartphone = smartphoneEntities.get(0);
        SmartphoneEntity secondSmartphone = smartphoneEntities.get(1);

        firstClient.getSmartphoneEntitySet().add(firstSmartphone);
        secondClient.getSmartphoneEntitySet().add(secondSmartphone);

        saveSmartphoneForClient(entityManager,firstClient);


//        entityManager.getTransaction().begin();
//        entityManager.persist(firstClient);
//        entityManager.persist(secondClient);
//        entityManager.getTransaction().commit();



//        SmartphoneEntity smartphoneEntity = prepareSmartphone("Xiaomi", "MI10", 2000);
//        saveSmartphone(entityManager, smartphoneEntity);
//
//        AddressEntity addressEntity = prepareAddress("Zielonka", "Polska");
//        ClientEntity clientEntity = prepareClient("Aleksander");
////
//        clientEntity.setAddressEntity(addressEntity);
//        addressEntity.setClientEntity(clientEntity);
//
//        saveClient(entityManager, clientEntity, addressEntity);

        entityManager.close();
        entityManagerFactory.close();


        System.out.println(clientEntities);
        System.out.println(smartphoneEntities);


    }

    private static  void saveSmartphoneForClient(EntityManager entityManager,ClientEntity clientEntity){
        entityManager.getTransaction().begin();
        entityManager.persist(clientEntity);
        entityManager.getTransaction().commit();
    }


    private static void saveClient(EntityManager entityManager, ClientEntity clientEntity, AddressEntity addressEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(addressEntity);
        entityManager.persist(clientEntity);
        entityManager.getTransaction().commit();
    }


    private static void saveSmartphone(EntityManager entityManager, SmartphoneEntity smartphoneEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(smartphoneEntity);
        entityManager.getTransaction().commit();
    }

    private static SmartphoneEntity prepareSmartphone(String model, String name, int price) {
        SmartphoneEntity smartphoneEntity = new SmartphoneEntity();
        smartphoneEntity.setModel(model);
        smartphoneEntity.setName(name);
        smartphoneEntity.setPrice(price);
        return smartphoneEntity;
    }

    private static ClientEntity prepareClient(String name) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(name);
        return clientEntity;
    }

    private static AddressEntity prepareAddress(String city, String country) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(city);
        addressEntity.setCountry(country);
        return addressEntity;
    }
}



