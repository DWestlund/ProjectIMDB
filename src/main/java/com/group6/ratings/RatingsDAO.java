package com.group6.ratings;

import com.group6.movies.Movies;

import javax.persistence.*;
import java.util.Collection;

public class RatingsDAO {


    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hibernate");
    private EntityTransaction transaction;

    public Collection<Ratings> readRatings(){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM ratings", Ratings.class);

            Collection<Ratings> allRatings = (Collection<Ratings>) query.getResultList();

            transaction.commit();

            return allRatings;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public Collection<Ratings> readRatings(int movieId){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM ratings WHERE movieId = ?", Ratings.class);
            query.setParameter(1, movieId);

            Collection<Ratings> allRatings = (Collection<Ratings>) query.getResultList();

            transaction.commit();

            return allRatings;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    public void createRatin(Ratings ratings){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();


            entityManager.persist(ratings);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
