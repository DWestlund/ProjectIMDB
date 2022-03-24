package com.group6.movies;

import javax.persistence.*;
import java.util.Collection;

public class MoviesDAO {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hibernate");
    private EntityTransaction transaction;

    public void createMovie(Movies movie){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();


            entityManager.persist(movie);


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    public Collection<Movies> readMovies(){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;


        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM movies", Movies.class);

            Collection<Movies> allMovies = (Collection<Movies>) query.getResultList();

            transaction.commit();

            for (Movies movie : allMovies){
                System.out.println(movie);
            }

            return allMovies;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    public Movies readSingleMovie(int movieId){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("SELECT * FROM movies WHERE movieId = ?", Movies.class);
            query.setParameter(1, movieId);

            Movies movie = (Movies) query.getSingleResult();

            transaction.commit();

            return movie;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }
    public Movies readSingleMovie(String title, String category){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();


            Query query = entityManager.createNativeQuery("SELECT * FROM movies WHERE title = ? AND category = ?", Movies.class);
            query.setParameter(1, title);
            query.setParameter(2, category);

            Movies movie = (Movies) query.getSingleResult();

            transaction.commit();

            return movie;

        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    public void updateMovie(int movieId, String newTitle, String newCategory){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Movies movie1 = entityManager.find(Movies.class, movieId);
            movie1.setTitle(newTitle);
            movie1.setCategory(newCategory);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void deleteMovie(Movies movie){

    }
    public void deleteMovie(int movieId){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("DELETE FROM movies WHERE movieId = ?");
            query.setParameter(1, movieId);

            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    public void deleteMovie(String title, String category){
        EntityManager entityManager = EMF.createEntityManager();
        transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNativeQuery("DELETE FROM movies " +
                    "WHERE title = ? " +
                    "AND category = ?");
            query.setParameter(1,title);
            query.setParameter(2,category);

            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void setup(){
        transaction = null;
    }
}
