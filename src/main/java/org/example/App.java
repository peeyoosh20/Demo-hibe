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
        Alien alien2=new Alien();
        alien2.setaId(102);
        alien2.setColor("white");
        alien2.setaName(new AlienName("James","Pal",
                "Anderson"));
        Configuration configuration=new Configuration().configure()
                .addAnnotatedClass(Alien.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(alien);
        session.save(alien2);
        alien=session.get(Alien.class,101);
       alien2=session.get(Alien.class,102);

        transaction.commit();
        System.out.println(alien);
        System.out.println(alien2);
    }
}
