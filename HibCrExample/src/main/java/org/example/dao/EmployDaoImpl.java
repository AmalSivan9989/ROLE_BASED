package org.example.dao;

import org.example.model.Employ;
import org.example.model.Login;
import org.example.util.EncryptPassword;
import org.example.util.SessionHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class EmployDaoImpl implements EmployDao{

    private static SessionFactory sessionFactory;
    private Session session;
    public EmployDaoImpl() {
        sessionFactory = SessionHelper.getSession();
    }

    public List<String> showEmployProjection(){
       session=sessionFactory.openSession();
       Criteria criteria=session.createCriteria(Employ.class);
        Projection projection= Projections.property("name");
        criteria.setProjection(projection);
        List<String>names=criteria.list();
        return names;
    }
    public List<Object[]>showEmployMultiProjection(){
        session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Employ.class);
        Projection projection1=Projections.property("name");
        Projection projection2=Projections.property("dept");
        Projection projection3=Projections.property("gender");
        Projection projection4=Projections.property("basic");
        ProjectionList pList=Projections.projectionList();
        pList.add(projection1);
        pList.add(projection2);
        pList.add(projection3);
        pList.add(projection4);
        criteria.setProjection(pList);

        return criteria.list();
    }

    @Override
    public List<Employ> showEmployDao() {
        session=sessionFactory.openSession();
        Criteria cr=session.createCriteria(Employ.class);
        return cr.list();
    }

    @Override
    public Employ searchEmployDao(int empno) {
       session=sessionFactory.openSession();
       Criteria cr=session.createCriteria(Employ.class);
       cr.add(Restrictions.eq("empno",empno));
       Employ employ=(Employ) cr.uniqueResult();
       return employ;
    }

    @Override
    public String addUser(Login login) {
        String encr= EncryptPassword.getCode(login.getPassCode());
        login.setPassCode(encr);
        session=sessionFactory.openSession();
        Transaction trans=session.beginTransaction();
        session.save(login);
        trans.commit();
        return "user added successfully";
    }

    @Override
    public Long authenticate(Login login) {
      String encry=EncryptPassword.getCode(login.getPassCode());
      login.setPassCode(encry);
      session=sessionFactory.openSession();
      Criteria cr=session.createCriteria(Login.class);
      cr.add(Restrictions.eq("userName",login.getUserName()));
      cr.add(Restrictions.eq("passCode",login.getPassCode()));
      cr.setProjection(Projections.rowCount());
      long count=(Long)cr.uniqueResult();
      return count;
    }
}
