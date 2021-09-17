package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop= Laptop.builder()
                .lId(201)
                .lName("Dell")
                .build();
        Laptop laptop1= Laptop.builder()
                .lId(202)
                .lName("Mac")
                .build();
        Alien alien=new Alien();
        alien.setaId(101);
        alien.setColor("Brown");
        alien.setaName(new AlienName("Peeyoosh","Mani",
                "Tiwari"));
        Alien alien2=new Alien();
        alien2.setaId(102);
        alien2.setColor("white");
        alien2.setaName(new AlienName("James","Pal",
                "Anderson"));
        alien.getLaptop().add(laptop);
        alien.getLaptop().add(laptop1);
        alien2.getLaptop().add(laptop);
        alien2.getLaptop().add(laptop1);
        List<Alien> alienList=new ArrayList<>();
        alienList.add(alien);
        alienList.add(alien2);
        laptop.setAliens(alienList);
        laptop1.setAliens(alienList);
        Configuration configuration=new Configuration().configure()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(alien);
        session.save(alien2);
        session.save(laptop);
        session.save(laptop1);
        alien=session.get(Alien.class,101);
       alien2=session.get(Alien.class,102);
       laptop=session.get(Laptop.class,201);
        transaction.commit();
        //System.out.println(alien);
        //System.out.println(alien2);
        //System.out.println(laptop);
    }
}
