package org.example.dao;

import org.example.model.Employ;
import org.example.util.SessionHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class EmployDaoImpl implements EmployDao{



    static SessionFactory sessionFactory;
    Session session;

    static{
        sessionFactory= SessionHelper.getConnection();
    }

    @Override
    public List<Employ> showEmployDao() {
        session=sessionFactory.openSession();
        Query query=session.createQuery("from Employ");
        List<Employ> employList=query.list();
        return employList;
    }

    @Override
    public Employ searchEmployDao(int empno) {
       session=sessionFactory.openSession();
       Query query=session.createQuery("from Employ where empno= "+empno);
       Employ employ=(Employ) query.uniqueResult();
       return employ;
    }

    @Override
    public String addEmployDao(Employ employ) {
        session=sessionFactory.openSession();
        Transaction trans=session.beginTransaction();
        session.save(employ);
        trans.commit();
        return "employ record inserted...";
    }

    @Override
    public String updateEmployDao(Employ employ) {
        Employ employFound=searchEmployDao(employ.getEmpno());
        if(employFound!=null){
            session=sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            session.update(employFound);
            trans.commit();
            return "employ record updated";
        }
        return "employ record not found...";
    }

    @Override
    public String deleteEmployDao(int empno) {
        Employ employFound=searchEmployDao(empno);
        if(employFound!=null){
            session=sessionFactory.openSession();
            Transaction trans=session.beginTransaction();
            session.delete(employFound);
            trans.commit();
            return "employ record deleted";
        }
        return "employ record not found...";
    }


}
