package com.spring;

import com.spring.Models.EmbeddedObject.Adress;
import com.spring.Models.Relationship.Inheritance.FourWheeler;
import com.spring.Models.Relationship.Inheritance.TwoWheeler;
import com.spring.Models.Relationship.User;
import com.spring.Models.Relationship.Vehicle;
import com.spring.Models.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // MARK : Before OneToOe
        /*UserDetails userDetails = new UserDetails();
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

        sessionFactory.close();*/


        final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();


        CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
        Root<Vehicle> from = criteriaQuery.from(Vehicle.class);

        criteriaQuery.select(from);
        criteriaQuery.where(criteriaBuilder.equal(from.get("vehicleName"),"Car"));

        List<Vehicle> vehicleList = session.createQuery(criteriaQuery).getResultList();



        /*
        Query query = session.getNamedQuery("VEHICLE.byNativeId");
        query.setParameter(0,"14");
        List<Vehicle> vehicleList = query.getResultList();
*/
/*
        Query query = session.createQuery("from Vehicle where vehicleId > ?");
        query.setParameter(0,5);

        List<Vehicle> vehicleList = query.getResultList();
*/


        /*User userReha = new User();
        userReha.setUserName("Reha Kılıç");
        session.save(userReha);

        User userSerap = new User();
        userSerap.setUserName("Serap Taşbaş");
        session.save(userSerap);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        vehicle.setUser(userReha);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Truck");
        vehicle2.setUser(userReha);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehicleName("Bike");
        vehicle3.setUser(userSerap);

        userReha.getVehicleList().add(vehicle);
        userReha.getVehicleList().add(vehicle2);
        userSerap.getVehicleList().add(vehicle3);

        session.save(vehicle);
        session.save(vehicle2);
        session.save(vehicle3);*/

        /*Query query = session.createQuery("from Vehicle");
        query.setFirstResult(1);//where to start from
        query.setMaxResults(2);//count

        List<Vehicle> vehicleList = query.getResultList();*/




/*        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Vehicle");

        TwoWheeler bike = new TwoWheeler();
        bike.setVehicleName("bike");
        bike.setStreetingHandle("bike streeting handle");

        FourWheeler car = new FourWheeler();
        car.setVehicleName("Car");
        car.setStreetingWheeler("Car streeting wheeler");

        session.save(vehicle);
        session.save(bike);
        session.save(car);
*/

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();




        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getVehicleName());
        }



/*

        session = sessionFactory.openSession();
        session.beginTransaction();

        vehicle = session.get(Vehicle.class,4);

        session.close();

        System.out.println(vehicle.getUser());

        sessionFactory.close();
*/
    }
}
