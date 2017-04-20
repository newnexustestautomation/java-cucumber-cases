package nl.newnexus.database.acties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Tester on 4/20/2017.
 */
public class DatabaseActies {
    private static DatabaseActies databaseActiesInstance = new DatabaseActies();

    private EntityManager entityManager;

    private static volatile boolean initialized = false;

    private DatabaseActies() {
        // nothing to do
    }

    public static DatabaseActies getDatabaseActiesInstance() {
        if (!initialized) {
            databaseActiesInstance.init();
        }

        return databaseActiesInstance;
    }

    private void init() {
        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        this.entityManager = entityManagerFactory.createEntityManager();

        this.entityManager.getTransaction().begin();

        initialized = true;
    }

    public boolean isEntityManagerCreated() {
        return this.entityManager != null;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
