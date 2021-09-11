package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alien=new Alien();
        alien.setaId(101);
        alien.setColor("Brown");
        alien.setaName(new AlienName("Peeyoosh","Mani",
                "Tiwari"));
        alien.setaId(102);
        alien.setColor("white");
        alien.setaName(new AlienName("James","Pal",
                "Anderson"));
        Configuration configuration=new Configuration().configure()
                .addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
       // alien=session.get(Alien.class,102);
        session.save(alien);
        transaction.commit();
        System.out.println(alien);
    }
}
