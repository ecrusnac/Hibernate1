package service;

import java.util.List;

import dao.HobbyDaoImplement;
import dao.HobbyDao;

import model.Hobbies;

import java.util.List;

public class HobbyService {

    private HobbyDaoImplement hobbyDao;

    public HobbyService() {
        hobbyDao = new HobbyDaoImplement();
    }

    public void persist(Hobbies entity) {
        hobbyDao.openCurrentSessionWithTransaction();
        hobbyDao.persist(entity);
        hobbyDao.closeCurrentSessionWithTransaction();
    }

    public void update(Hobbies entity) {
        hobbyDao.openCurrentSessionWithTransaction();
        hobbyDao.update(entity);
        hobbyDao.closeCurrentSessionWithTransaction();
    }

    public Hobbies findById(Integer id) {
        hobbyDao.openCurrentSession();
        Hobbies hobby = hobbyDao.findById(id);
        hobbyDao.closeCurrentSession();
        return hobby;
    }

    public void delete(Integer id) {
        hobbyDao.openCurrentSessionWithTransaction();
        Hobbies hobby = hobbyDao.findById(id);
        hobbyDao.delete(hobby);
        hobbyDao.closeCurrentSessionWithTransaction();
    }

    public List<Hobbies> findAll() {
        hobbyDao.openCurrentSession();
        List<Hobbies> hobby = hobbyDao.findAll();
        hobbyDao.closeCurrentSession();
        return hobby;
    }

    public void deleteAll() {
        hobbyDao.openCurrentSessionWithTransaction();
        hobbyDao.deleteAll();
        hobbyDao.closeCurrentSessionWithTransaction();
    }

    public HobbyDao hobbyDao() {
        return hobbyDao;
    }
}

