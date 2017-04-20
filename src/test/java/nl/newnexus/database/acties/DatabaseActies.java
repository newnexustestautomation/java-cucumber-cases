package nl.newnexus.database.acties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Tester on 4/20/2017.
 */
public class DatabaseActies {

    private static DatabaseActies ourInstance;
    public boolean valid = false;
    private EntityManager em = null;

    public boolean init(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        valid = true;
        return true;
    }

    public boolean AccountAanwezig(String email){

        Query query = em.createQuery("select c from Customers c where c.customersEmailAddress = '"+email+"'");
        if((Integer)  query.getResultList().size()>=1) {
            System.out.println("\nMomenteel zijn er "+(Integer)  query.getResultList().size()+" accounts met emailadres "+email+ " in de database!");
            return true;
        }
        return false;

    }

    public static DatabaseActies getInstance() {
        if(ourInstance==null)
            ourInstance = new DatabaseActies();
        return ourInstance;
    }

}
