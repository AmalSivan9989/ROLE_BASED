package org.example.hib;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class EmployShowMain {
    public static void main(String[] args) {
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Query query = (Query) session.createQuery("from Employ");
        List<Employ> employList =query.list();
        for (Employ employ : employList) {
            System.out.println(employ);
        }



    }

}
