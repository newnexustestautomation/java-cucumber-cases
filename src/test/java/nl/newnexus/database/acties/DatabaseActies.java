package nl.newnexus.database.acties;

import com.sun.org.apache.xml.internal.security.Init;
import org.hibernate.metamodel.relational.Database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.security.PublicKey;

/**
 * Created by Tester on 4/20/2017.
 */
public class DatabaseActies {

    private static DatabaseActies ourInstance;
    public boolean valid = false;
    private EntityManager em = null;

    public boolean Init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zelf verwijzen naar persistence unit");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        valid = true;
        return true;
    }

    public boolean accountAanwezig(String email){
        Query query = em.createQuery("<zelf query schrijven>");
        if((Integer) query.getResultList().size()>=1) {
            System.out.print("\nMomenteel zijn er " + (Integer) query.getResultList().size() + "accounts met emailadres" + email + "in de database");
            return true;
        }
        return false;
        }


    public static DatabaseActies getOurInstance(){
        if

        
    }



    }

