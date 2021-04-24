package Task1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Maine {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("smartphone_shop_db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        SmartphoneEntity smartphoneEntity = prepareSmartphone();
        saveSmartphone(entityManager, smartphoneEntity);

//        List<SmartphoneEntity> smartphoneEntities1 = listSmartphone();
//        saveLisSmartphone(entityManager, smartphoneEntities1);

        entityManager.close();
        entityManagerFactory.close();

    }
    //trzeba by to opędzić w foreach - ale potem w springDate sa gotowe adnotace do tego
//    private static void saveLisSmartphone(EntityManager entityManager, List<SmartphoneEntity> smartphoneEntity) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(smartphoneEntity);
//        entityManager.getTransaction().commit();
//    }


    private static void saveSmartphone(EntityManager entityManager, SmartphoneEntity smartphoneEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(smartphoneEntity);
        entityManager.getTransaction().commit();
    }

    private static SmartphoneEntity prepareSmartphone() {
        SmartphoneEntity smartphoneEntity = new SmartphoneEntity();
        smartphoneEntity.setModel("Samsung");
        smartphoneEntity.setName("Galaxy1");
        smartphoneEntity.setPrice(50000);
        return smartphoneEntity;
    }


//    private static List<SmartphoneEntity> listSmartphone() {
//        List<SmartphoneEntity> listSmartphone = new ArrayList<>();
//        listSmartphone.add(new SmartphoneEntity("HTC", "D1", 80000));
//        listSmartphone.add(new SmartphoneEntity("Xiami","W1",5500));
//        return listSmartphone;
//    }
}



