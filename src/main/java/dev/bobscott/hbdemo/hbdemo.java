package dev.bobscott.hbdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class hbdemo {


    public static void main(String[] args) {
        SessionFactory sessionFactory=null;
        try {
            sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Error creating factory");
            System.out.println(e.getMessage());
            return;
        }


        Employee employee = new Employee("Daffy", "Duck", "Quackers");

        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error saving employee");
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
        sessionFactory.close();
    }
}
