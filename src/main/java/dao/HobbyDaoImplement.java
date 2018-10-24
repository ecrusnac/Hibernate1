package dao;

import model.Hobbies;
import model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HobbyDaoImplement implements HobbyDao<Hobbies, Integer> {

        private Session currentSession;

        private Transaction currentTransaction;

        public HobbyDaoImplement() {
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


        public void persist(Hobbies entity) {
            getCurrentSession().save(entity);
        }

        public void update(Hobbies entity) {
            getCurrentSession().update(entity);
        }

        public Hobbies findById(Integer id) {
            Hobbies hobby = getCurrentSession().get(Hobbies.class, id);
            return hobby;
        }

        public void delete(Hobbies entity) {
            getCurrentSession().delete(entity);
        }

        @SuppressWarnings("JpaQlInspection")
        public List<Hobbies> findAll() {
            List<Hobbies> hobby = (List<Hobbies>) getCurrentSession().createQuery("from Hobbies ").list();
            return hobby;
        }

        public void deleteAll() {
            List<Hobbies> entityList = findAll();
            for (Hobbies entity : entityList) {
                delete(entity);
            }
        }
}
