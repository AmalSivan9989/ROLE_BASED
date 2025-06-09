package org.example.dao;

import com.mysql.cj.log.Log;
import org.example.model.Employ;
import org.example.model.Login;
import org.example.util.EncryptPassword;
import org.example.util.SessionHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployDaoImpl implements EmployDao {


    private static SessionFactory sessionFactory;
    private Session session;
    static{
        sessionFactory= SessionHelper.getSession();
    }
    @Override
    public List<Employ> showEmployDao() {
      session =sessionFactory.openSession();
        Query query=session.getNamedQuery("show Employ");
        List<Employ> employList=query.list();
        return employList;
    }

    @Override
    public Employ searchEmployDao(int empno) {
      session=sessionFactory.openSession();
      Query query=session.getNamedQuery("search Employ");
      query.setParameter("empno",empno);
      Employ employ=(Employ)query.uniqueResult();
      return employ;
    }

    @Override
    public int validate(Login login) {
        String encr= EncryptPassword.getCode(login.getPassCode());
        session=sessionFactory.openSession();
        Query query=session.getNamedQuery("validate");
        query.setParameter("userName",login.getUserName());
        query.setParameter("passCode",encr);
        Login loginFound=(Login) query.uniqueResult();
        if(loginFound!=null){
            return 1;
        }
        else{
            return 0;
        }


    }
}
