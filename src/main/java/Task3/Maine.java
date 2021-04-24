package Task3;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.stream.Collectors;


public class Maine {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory4 = Persistence.createEntityManagerFactory("smartphone_shop_db");
        EntityManager entityManager = entityManagerFactory4.createEntityManager();

        List<SmartphoneEntity> smartphoneEntities = entityManager.createQuery("select s from SmartphoneEntity s", SmartphoneEntity.class)
                .getResultList();

        List<ClientEntity> clientEntities = entityManager.createQuery("select c from ClientEntity c", ClientEntity.class)
                .getResultList();



        getSmartphoneForClient("Artur",clientEntities);
        getSmartphoneNotOrdered(smartphoneEntities);
        System.out.println("***********************************************");



        entityManager.close();
        entityManagerFactory4.close();


    }

    public static List<SmartphoneEntity> getSmartphoneForModel(String model, List<SmartphoneEntity> smartphoneEntityList){
        return smartphoneEntityList.stream()
                .filter(smartphoneEntity -> model == null || smartphoneEntity.getModel().equals(model))
                .collect(Collectors.toList());
    }


    public static void getSmartphoneForClient(String name, List<ClientEntity> clientEntities){
        clientEntities.stream()
                .filter(clientEntity -> name == null || clientEntity.getName().equals(name))
                .filter(clientEntity -> !clientEntity.getSmartphoneEntitySet().isEmpty())
                .forEach(clientEntity -> clientEntity.getSmartphoneEntitySet().forEach(System.out::println));
    }

    public static void getSmartphoneNotOrdered( List<SmartphoneEntity> smartphoneEntities){
        smartphoneEntities.stream()
        .filter(smartphoneEntity -> smartphoneEntity.getClientEntitySet().isEmpty())
                .forEach(smartphoneEntity -> smartphoneEntity.getClientEntitySet()
                        .forEach(System.out::println));
    }


}



