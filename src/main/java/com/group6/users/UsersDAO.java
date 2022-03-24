package com.group6.users;

import javax.persistence.*;
import java.util.Collection;

public class UsersDAO {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hibernate");
    private EntityTransaction transaction;

    public Collection<Users> readUsers(){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;


        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM users", Users.class);

            Collection<Users> allUsers = (Collection<Users>) query.getResultList();

            transaction.commit();

            return allUsers;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

}
