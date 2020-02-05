import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AirportDAO {

    public void insert(Airport airport){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(airport);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void searchByName(String name2){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Airport> airports = entityManager.
                createQuery("select a from Airport a where a.name like :name2").
                setParameter("name2",name2).
                getResultList();
        System.out.println(airports);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void deleteById(int id){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Airport airport2 = entityManager.find(Airport.class,id);
        entityManager.remove(airport2);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void update(Airport airport, int id){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Airport airport2 = entityManager.find(Airport.class,id);
        airport2.setName(airport.getName());
        airport2.setAddress(airport.getAddress());
        airport2.setCity(airport.getCity());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
