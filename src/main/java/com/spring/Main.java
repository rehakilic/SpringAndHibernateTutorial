package com.spring;

import com.spring.Models.EmbeddedObject.Adress;
import com.spring.Models.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class Main {
    public static void main(String[] args) {

        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Reha Kılıç");


        Adress adress = new Adress();
        adress.setCountry("country1");
        adress.setPinCode("pin1");
        adress.setStreet("street1");

        userDetails.setAddress(adress);
        userDetails.setBio("Test bio");
        userDetails.setDateOfBirth(new Date());


        Adress adress2 = new Adress();
        adress2.setCountry("country2");
        adress2.setPinCode("pin2");
        adress2.setStreet("street2");

        Adress adress3 = new Adress();
        adress3.setCountry("country3");
        adress3.setPinCode("pin3");
        adress3.setStreet("street3");

        userDetails.getListOfOtherAddresses().add(adress2);
        userDetails.getListOfOtherAddresses().add(adress3);

        final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(userDetails);

        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();


        session = sessionFactory.openSession();
        session.beginTransaction();

        userDetails = session.get(UserDetails.class,4);

        session.close();

        System.out.println(userDetails.getUserName());
        System.out.println(userDetails.getListOfOtherAddresses().size());

        sessionFactory.close();
    }
}
