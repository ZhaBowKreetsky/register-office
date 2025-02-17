package register.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import register.domain.Person;
import register.domain.PersonMale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public class PersonManager {

    public static void main(String[] args) {

//        sessionExample();

        jpaExample();

    }

    private static void jpaExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = new PersonMale();
        p.setFirstName("Alex");
        p.setLastName("Mason");
        em.persist(p);
        System.out.println(p.getPersonId());

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        List list = em.createQuery("FROM Person").getResultList();
        list.forEach(p1 -> System.out.println(p1));

        em.close();
    }

    private static void sessionExample() {
        SessionFactory sessionFactory = buildSessionFactory();

        System.out.println();
        System.out.println();
        System.out.println();

        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Person p = new PersonMale();
        p.setFirstName("Brandon");
        p.setLastName("Rogers");

        Long id = (Long) session.save(p);
//        session.persist(p);
        System.out.println(id);

        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        System.out.println(person);
        session.close();

        session = sessionFactory.openSession();
        List<Person> list = session.createQuery("FROM Person", Person.class).list();
        list.forEach(p1 -> System.out.println(p));
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
