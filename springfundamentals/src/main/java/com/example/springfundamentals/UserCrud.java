package com.example.springfundamentals;

import javax.persistence.*;

public class UserCrud {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myCrudOperations");
        EntityManager em = emf.createEntityManager();
        EntityTransaction emtx = em.getTransaction();

        try{

            emtx.begin();

            // Create a Record
            User user = new User("Arjun","SN");
            em.persist(user);

            // Retrieve a Record
            user = em.find(User.class,1L);
            System.out.println(user);

            // Update a Record
            user.setLname("CheckLnameUpdate");
            emtx.commit();
            System.out.println(user);

            // Delete a Record
            em.remove(user);
            emtx.commit();

        }catch (Exception e){
            if(emtx.isActive()){
                emtx.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }

    }
}