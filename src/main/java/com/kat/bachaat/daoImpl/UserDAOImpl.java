package com.kat.bachaat.daoImpl;

import com.kat.bachaat.dao.UserDAO;
import com.kat.bachaat.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveUser(User user) {
        try {
            System.out.println("??????????????????????"+"enter dao layer");
            sessionFactory.getCurrentSession().save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public List<User> getUsers() {
        List<User> userList=sessionFactory.getCurrentSession()
                .createQuery("FROM User", User.class)
                .getResultList();
        if(userList==null|| userList.size()==0){
            throw new RuntimeException("cannot find userlist.");
        }
        return userList;
    }

    public User getUserByUserName(String firstName) {
        try {
            User user = sessionFactory
                    .getCurrentSession()
                    .createQuery("FROM User where firstName=:firstName", User.class)
                    .setParameter("firstName", firstName)
                    .getSingleResult();
            return user;
        }
        catch(Exception e){
                throw  new RuntimeException(e.getMessage());
            }
    }
}
