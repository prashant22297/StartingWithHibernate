package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        System.out.println("Project Started");
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
//        Creating student
        Student st = new Student();
        st.setId(102);
        st.setName("Prashant");
        st.setCity("China");
        System.out.println(st);
//        Creating object of address class
        Address ad = new Address();
        ad.setStreet("Tajopur");
        ad.setCity("Mau");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(22.2222);
//        Reading image
        FileInputStream fis = new FileInputStream("src/Pic.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(st);
        session.save(ad);
        System.out.println("DONE");
        session.getTransaction().commit();
        session.close();



    }
}
