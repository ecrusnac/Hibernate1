package dao;

import model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class PersonDaoImplement implements PersonDao<Person, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public PersonDaoImplement() {
    }

    private static SessionFactory getSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }


    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }


    public void persist(Person entity) {
        getCurrentSession().save(entity);
    }

    public void update(Person entity) {
        getCurrentSession().update(entity);
    }

    public Person findById(Integer id) {
        Person person = getCurrentSession().get(Person.class, id);
        return person;
    }

    public void delete(Person entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("JpaQlInspection")
    public List<Person> findAll() {
        List<Person> users = (List<Person>) getCurrentSession().createQuery("from Person ").list();
        return users;
    }

    public void deleteAll() {
        List<Person> entityList = findAll();
        for (Person entity : entityList) {
            delete(entity);
        }
    }
}
