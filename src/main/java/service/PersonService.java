package service;

import java.util.List;

import dao.PersonDao;
import dao.PersonDaoImplement;
import model.Person;


public class PersonService {


    private PersonDaoImplement personDao;

    public PersonService() {
        personDao = new PersonDaoImplement();
    }

    public void persist(Person entity) {
        personDao.openCurrentSessionWithTransaction();
        personDao.persist(entity);
        personDao.closeCurrentSessionWithTransaction();
    }

    public void update(Person entity) {
        personDao.openCurrentSessionWithTransaction();
        personDao.update(entity);
        personDao.closeCurrentSessionWithTransaction();
    }

    public Person findById(Integer id) {
        personDao.openCurrentSession();
        Person person = personDao.findById(id);
        personDao.closeCurrentSession();
        return person;
    }

    public void delete(Integer id) {
        personDao.openCurrentSessionWithTransaction();
        Person person = personDao.findById(id);
        personDao.delete(person);
        personDao.closeCurrentSessionWithTransaction();
    }

    public List<Person> findAll() {
        personDao.openCurrentSession();
        List<Person> person = personDao.findAll();
        personDao.closeCurrentSession();
        return person;
    }

    public void deleteAll() {
        personDao.openCurrentSessionWithTransaction();
        personDao.deleteAll();
        personDao.closeCurrentSessionWithTransaction();
    }

    public PersonDao personDao() {
        return personDao;
    }
}

